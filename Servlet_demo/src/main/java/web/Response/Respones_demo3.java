package web.Response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 响应的基本用法
 */
@WebServlet("/resp3")
public class Respones_demo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

/**
 * Response设置响应数据功能介绍
 * 响应数据分为3部分:
 * ●1.响应行: HTTP/1.1 200 OK
 *       void setStatus(int sc) :设置响应状态码
 * ●2.响应头: Content-Type: text/html
 *      void setHeader(String name, String value) :设置响应头键值对
 * ●3. 响应体: <html><head>head><body></body></html>
 *      PrintWriter getWriter():获取字符输出流
 *      ServletOutputStream getOutputStream():获取字节输出流
 */
