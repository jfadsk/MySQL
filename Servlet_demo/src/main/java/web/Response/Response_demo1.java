package web.Response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 相应重定向
 */
@WebServlet("/resp1")
public class Response_demo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1------");

    /*
        //重定向
        //1.设置响应状态码
            response.setStatus(302);
        //2.设置响应头Location  路劲需要加虚拟目录的路劲 在本例中也就是 Servlet_demo
            response.setHeader("Location","/Servlet_demo/resp2");
    */

//       简化方式:
        //在需要虚拟目录时  最好动态获取虚拟目录
        String contextPath = request.getContextPath();

        response.sendRedirect(contextPath+"/resp2");
//        response.sendRedirect("/Servlet_demo/resp2");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

/**
 * ● 实现方式:
 * resp.setStatus(302);
 * resp.setHeader("location","资源B的路径");
 * 简化方式：
 * resp.sendRedirect("资源B的路径");
 *
 * ● 重定向特点:
 * ➢ 浏览器地址栏路径发生变化
 * ➢ 可以重定向到任意位置的资源(服务器内部、外部均可)
 * ➢ 两次请求，不能在多个资源使用request共享数据
 */


/**  路径问题
 * ● 明确路径谁使用?
 * ➢ 浏览器使用: 需要加虚拟目录(项目访问路径)
 * ➢ 服务端使用: 不需要加虚拟目录
 * ● 练习:
 * ➢ <ahref= ‘路径>      加虚拟目录
 * ➢ <form action= '路径’ >      加虚拟目录
 * ➢ req. getRequestDispatcher(“路径")      不加虚拟目录
 * ➢ resp sendRedirect(“路径")      加虚拟目录
 */

