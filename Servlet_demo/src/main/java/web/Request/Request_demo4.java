package web.Request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 请求转发
 */
@WebServlet("/req4")
public class Request_demo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo4--------");

        request.setAttribute("id","123");
        //请求转发
        request.getRequestDispatcher("/req5").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

/**请求转发
 * req.getRequestDispatcher("资源B路径").forward(req,resp);
 *
 * *资源共享数据
 *
 * 请求转发资源间共享数据:使用Request对象
 * ●void setAttribute(String name, Object 0):存储数据到request域中
 * ●Object getAttribute(String name):根据key,获取值
 * ●void removeAttribute(String name):根据key,删除该键值对
 *
 * 请求转发特点:
 * ➢浏览器地址栏路径不发生变化
 * ➢
 * 只能转发到当前服务器的内部资源
 * ➢
 * 一次请求， 可以在转发的资源间使用request共享数据
 */