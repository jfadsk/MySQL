package web.Request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 中文乱码的问题
 */
@WebServlet("/req3")
public class Request_demo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //POST 解决方案
//        request.setCharacterEncoding("UTF-8");

        //GET解决方案
        String username = request.getParameter("username");
        System.out.println("解决乱码前："+username);

//        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
//        username = new String(bytes, StandardCharsets.UTF_8);
        username = new String(username.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        System.out.println("解决乱码后："+username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

/*
请求参数如果存在中文数据，则会乱码
解决方案:
➢
    POST:设置输入流的编码
        req.setCharacterEncoding("UTF-8");
    GET :  乱码原因: tomcat 进行RL解码，默认的字符集IS0-8859-1
        //3.1先对乱码数据进行编码:转为字节数组
            byte[] bytes = username.getBytes (StandardCharsets.ISO_ 8859_ .1) ;
        //3.2字节数组解码
            username = new String (bytes, StandardCharsets.UtF 8);
    GET的方法POST也能用  在Tomcat8 之后 就没有乱码的问题了


 */