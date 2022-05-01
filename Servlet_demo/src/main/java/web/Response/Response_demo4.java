package web.Response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应字符数据
 */
@WebServlet("/resp4")
public class Response_demo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//  响应字符数据
        //解决中文乱码问题
        response.setContentType("text/html;charset=utf-8");
        //1.获取字符输出流
        PrintWriter writer = response.getWriter();  //中文会乱码
//        response.setHeader("content-type","text/html");
        writer.write("aaaaa");
        writer.write("<h1>你好</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

/**
 * 使用:
 * 1.通过Response对象获取字符输出流
 * PrintWriter writer = resp.getWriter();
 * 2.写数据
 * writer.write(" aaa ");
 * 3.中文乱码问题：  原因通过Response获取的字符输出流默认编码: IS0-8859-1
 * response.setContentType("text/html ; charset=utf-8");
 * 前面text/html是提示咦html的格式输出内容
 */