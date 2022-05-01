package web.Request;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/req1")
public class Requset_demo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 获取请求行的数据

//        String getMethod():获取请求方式: GET
        String method = req.getMethod();
        System.out.println(method);
//        String getContextPath():获取虚拟目录(项目访问路径): /Servlet-demo
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
//        StringBuffer getRequestURL():获取URL(统-资源定位符): http://localhost:8080/Servlet-demo/req1 .
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL.toString());
//        String getRequestURI():获取URI(统-资源标识符): /Servlet-demo/req1
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
//        String getQueryString():获取请求参数(GET方式) : username=zhangsan&password=123
        String queryString = req.getQueryString();
        System.out.println(queryString);

//获取请求头的数据

//        String getHeader(String name):根据请求头名称，获取值
        String header = req.getHeader("user-agent");   //浏览器的版本
        System.out.println(header);

        BufferedReader reader = req.getReader();
        String line = reader.readLine();
        System.out.println(line);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        System.out.println(method);

        this.doGet(req, resp);
//        获取请求体的数据

//        ServletInputStream getInputStream(): 获取字节输入流
//        ServletInputStream inputStream = req.getInputStream();
//        System.out.println(inputStream.toString());

//        BufferedReader getReader():获取字符输入流
//        BufferedReader reader = req.getReader();
//        String line = reader.readLine();
//        System.out.println(line);

    }
}
