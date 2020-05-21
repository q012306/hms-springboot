package com.goodguy.hms.controller;

import com.goodguy.hms.pojo.Department;
import com.goodguy.hms.pojo.User;
import com.goodguy.hms.result.Result;
import com.goodguy.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username,DigestUtils.md5DigestAsHex(requestUser.getPassword().getBytes()));
        if (null == user) {
            return new Result(400);
        } else {
            session.setAttribute("user", user);
            return new Result(200);
        }
    }
    @CrossOrigin
    @PostMapping(value = "/api/register")
    @ResponseBody
    public Result register(@RequestBody User registerUser) {
        String username = registerUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        if (userService.isExist(username)) {
            return new Result(400);
        } else {
            registerUser.setPassword(DigestUtils.md5DigestAsHex(registerUser.getPassword().getBytes()));
            userService.add(registerUser);
            return new Result(200);
        }
    }

    @CrossOrigin
    @GetMapping(value = "/api/users")
    @ResponseBody
    public List<User> list() {
        return userService.list();
    }

    @CrossOrigin
    @GetMapping(value = "/api/user")
    @ResponseBody
    public User findmyuser(HttpSession session) {
        return (User)session.getAttribute("user");
    }

    @CrossOrigin
    @PostMapping(value = "/api/changepassword")
    @ResponseBody
    public User changepassword(@RequestBody User user,HttpSession session) {
        User myuser =(User)session.getAttribute("user");
        myuser.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userService.addOrUpdate(myuser);
        return myuser;
    }
}

