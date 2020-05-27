package com.goodguy.hms.error;

import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * vue 只有 index.html 这一个页面，所有的其它内容都是在这个页面里动态渲染的。直接在后端访问 /login 路径时，服务器会后端并没有这个路径对应的内容，所以返回了 Error Page
 * 实现 ErrorPageRegistrar 接口的类 ErrorConfig，把默认的错误页面设置为 /index.html
 */
@Component
public class ErrorConfig implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/index.html");
        registry.addErrorPages(error404Page);
    }

}