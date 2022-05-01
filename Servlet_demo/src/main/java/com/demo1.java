package com;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/demo1")
public class demo1 implements Servlet {

    @Override //在开始时只执行一次
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override  //可以执行多次  浏览器没刷新一次就执行一次
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet hello~~");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override // 在结束时执行一次
    public void destroy() {

    }
}
