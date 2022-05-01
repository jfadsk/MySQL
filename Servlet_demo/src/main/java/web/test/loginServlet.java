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

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //1.post接收中文乱码解决
        request.setCharacterEncoding("utf-8");

        //1.接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2.get接收中文乱码解决
       username = new String(username.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);

        //2.调用mybatis
        //2.1 获取 SqlSessionFactory对象
       /* 把下面的代码块封装成工具类   sqlSessionFactory  以便于其他的类调用  应为sqlSessionFactory 本身是一个工厂有了连接池
            在多次创建的sqlSessionFactory工厂的话  毫无必要
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        */
        SqlSessionFactory sessionFactory = sqlSessionFactory.getSessionFactory();
        //2.2获取SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();
        //2.3获取Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //2.4调用方法
        User user = mapper.select(username, password);
        //2.5释放对象
        sqlSession.close();

        //获取响应字符流
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //3.判断user是否为NULL
        if( user != null ) {
            writer.write("登录成功");
        } else {
            writer.write("登录失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
