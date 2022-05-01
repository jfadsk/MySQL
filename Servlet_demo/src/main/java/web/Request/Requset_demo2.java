package web.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/req2")
public class Requset_demo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get------");

        //1.获取所有参数的Map集合
        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            System.out.print(key+":");
            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value+" ");
            }
            System.out.println();
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username);
        System.out.println(password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post------");

        //1.获取所有参数的Map集合
        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            System.out.print(key+":");
            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value+" ");
            }
            System.out.println();
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println(username);
        System.out.println(password);

        for (String value : hobbies ) {
            System.out.println(value);
        }
    }
}

/**
 * Map<String, String[ ]> getParameterMap():获取所有参数Map集合
 * String[ ] getParameterValues(String name) :根据名称获取参数值(数组)
 * String getParameter(String name):根据名称获取参数值(单个值)
 */
