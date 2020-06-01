package com.goodguy.hms.interceptor;

import com.goodguy.hms.pojo.Person;
import com.goodguy.hms.pojo.Recruitment;
import com.goodguy.hms.pojo.User;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 判断 session 中是否存在 user 属性，如果存在就放行，如果不存在就跳转到 login 页面
 * Interceptor 即拦截器，
 * 在 Springboot 继承拦截器的接口，
 * 然后实现 preHandle 方法。
 * preHandle 方法里的代码会在访问需要拦截的页面时执行。
 */

public class AuthorityInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o){
        // 放行 options 请求，否则无法让前端带上自定义的 header 信息，导致 sessionID 改变
        if (HttpMethod.OPTIONS.toString().equals(httpServletRequest.getMethod())) {
            httpServletResponse.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }

        HttpSession session = httpServletRequest.getSession();
        String uri = httpServletRequest.getRequestURI();
        System.out.println(uri);
        if(!( uri.equals("/login") || uri.equals("/api/login") || uri.equals("/api/register") )){
            User user = (User) session.getAttribute("user");
            if(user==null) {
                return false;
            }
        }

        if( uri.equals("/api/departments") || uri.equals("/api/departmentsdelete")){
            Person person = (Person)session.getAttribute("person");
            if(!"董事长".equals(person.getSjob())){
                System.out.println(person.getSjob() + "职务无对应权限");
                return false;
            }
        }

        if( uri.equals("/api/persons") || uri.equals("/api/personsdelete")){
            Person person = (Person)session.getAttribute("person");
            if(!"人事经理".equals(person.getSjob()) && !"董事长".equals(person.getSjob())){
                System.out.println(person.getSjob() + "职务无对应权限");
                return false;
            }
        }

        if( uri.equals("/api/randps") || uri.equals("/api/randpsdelete")){
            Person person = (Person)session.getAttribute("person");
            if(!"财务经理".equals(person.getSjob()) && !"董事长".equals(person.getSjob())){
                System.out.println(person.getSjob() + "职务无对应权限");
                return false;
            }
        }

        if(/* uri.equals("/api/recruitments") || */uri.equals("/api/recruitmentsdelete") || uri.equals("/api/personhire")){
            Person person = (Person)session.getAttribute("person");
            if(!"人事经理".equals(person.getSjob()) && !"董事长".equals(person.getSjob())){
                System.out.println(person.getSjob() + "职务无对应权限");
                return false;
            }
        }

        if( uri.equals("/api/salarys") || uri.equals("/api/salarysdelete")){
            Person person = (Person)session.getAttribute("person");
            if(!"财务经理".equals(person.getSjob()) && !"董事长".equals(person.getSjob())){
                System.out.println(person.getSjob() + "职务无对应权限");
                return false;
            }
        }

        if( uri.equals("/api/trainings") || uri.equals("/api/trainingsdelete")){
            Person person = (Person)session.getAttribute("person");
            if(!"技术经理".equals(person.getSjob()) && !"董事长".equals(person.getSjob())){
                System.out.println(person.getSjob() + "职务无对应权限");
                return false;
            }
        }

        if( uri.equals("/api/users") || uri.equals("/api/usersdelete")){
            Person person = (Person)session.getAttribute("person");
            if(!"董事长".equals(person.getSjob())){
                System.out.println(person.getSjob() + "职务无对应权限");
                return false;
            }
        }
        return true;
    }
}