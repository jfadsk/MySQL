package web.Response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应字节数据
 */
@WebServlet("/resp5")
public class Response_demo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//  响应字节数据
        //1.读取文件
        FileInputStream stream = new FileInputStream("D://图片//照片//a.jpg");
        //2.获取字节输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //3.完成流的copy
//        byte[] bytes = new byte[1024];
//        int len = 0;
//        while((len=stream.read(bytes)) != -1 ) {
//            outputStream.write(bytes, 0, len);
//        }

        //导入的IO流的jar包
        IOUtils.copy(stream, outputStream);

        stream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

