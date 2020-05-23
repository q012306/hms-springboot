package com.goodguy.hms.controller;

import com.goodguy.hms.pojo.Person;
import com.goodguy.hms.pojo.User;
import com.goodguy.hms.result.Result;
import com.goodguy.hms.service.PersonService;
import com.goodguy.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    PersonService personService;

    @CrossOrigin
    @PostMapping(value = "/api/login")
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
    public Result register(@RequestBody User registerUser) {
        String username = registerUser.getUsername();
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
    public List<User> list() {
        return userService.list();
    }

    @PostMapping("/api/users")
    @CrossOrigin
    public User addOrUpdate(@RequestBody User user){
        if(!userService.getById(user.getId()).getPassword().equals(user.getPassword()))
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userService.addOrUpdate(user);
        return user;
    }

    @CrossOrigin
    @GetMapping(value = "/api/user")
    public User findmyuser(HttpSession session) {
        return (User)session.getAttribute("user");
    }

    @CrossOrigin
    @GetMapping(value = "/api/usergetmyperson")
    public Person usergetmyperson(HttpSession session) {
        User user = (User)session.getAttribute("user");
        Person person = new Person();
        try{
            person = personService.getBySid(user.getSid());
        }catch(NullPointerException e) {
            System.out.println("用户无对应绑定员工账号");
        }
        return person;
    }

    @CrossOrigin
    @PostMapping(value = "/api/changepassword")
    public User changepassword(@RequestBody User user,HttpSession session) {
        User myuser =(User)session.getAttribute("user");
        myuser.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userService.addOrUpdate(myuser);
        return myuser;
    }

    @PostMapping("/api/usersdelete")
    @CrossOrigin
    public void delete(@RequestBody User user){
        userService.deleteById(user.getSid());
    }
}

