package controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class SaveFileController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            // request.setCharacterEncoding("UTF-8");
            // 创建一个工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(1024000);// 设置缓冲区大小
            // 创建一个ServletFileUpload对象(构造方法中需要factory帮忙)
            ServletFileUpload  upload = new ServletFileUpload(factory);
            upload.setSizeMax(102400000);
            // 通过upload解析request对象(解析目的是因为请求携带的信息都在request对象中)
            List<FileItem> itemList = upload.parseRequest(request);
            for(FileItem item: itemList){
                if(item.isFormField()){ // 是一个普通的组件
                    //注意不能使用request.getParameter("key");来获取   request对象已经被解析了
//                    System.out.println(request.getParameter("username"));
                    String key = item.getFieldName();//获取组件的name属性
                    //String value = item.getString();//获取组件的value属性
                    String value = item.getString("UTF-8");//使用重载方法传递处理字符集的key
                    System.out.println(key+"--"+value);
                } else { // file文件
                    String key = item.getFieldName(); // 获取组件的name属性
                    String realFileName = item.getName(); // 获取上传文件的真实文件名
                    //如果传递的文件真实中文名有问题
                    //request.setCharacterEncoding("UTF-8");
                    //upload.setHeaderEncoding("UTF-8");
                    System.out.println(key+"---"+realFileName);
                    // 获取根目录
                    this.getServletContext().getRealPath("/");
                    InputStream inputStream = item.getInputStream();
                    item.write(new File("D://test/"+realFileName));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
