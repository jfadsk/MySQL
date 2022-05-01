package web.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import utils.sqlSessionFactory;
import web.test.mapper.UserMapper;
import web.test.pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        username = new String(username.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        System.out.println(username);

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);


       /* String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        */


        SqlSessionFactory sessionFactory = sqlSessionFactory.getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();


        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User select = mapper.selectByUserName(username);

        
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (select != null) {
            writer.write("用户名已注册");
        } else {
            mapper.insert(user);
            writer.write("注册成功");
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
