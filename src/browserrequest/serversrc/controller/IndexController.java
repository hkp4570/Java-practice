package browserrequest.serversrc.controller;
import browserrequest.serversrc.server.HttpServlet;
import browserrequest.serversrc.server.HttpServletRequest;
import browserrequest.serversrc.server.HttpServletResponse;

public class IndexController extends HttpServlet {
    //一个控制层

    public void service(HttpServletRequest request, HttpServletResponse response){
        //1.获取请求发送过来携带的参数?
        System.out.println("控制层执行啦");
        //2.找到某一个业务层的方法 做事

        //3.将最终业务层执行完毕的结果 交还给服务器 让服务器写回给浏览器
        response.write("响应信息");
    }

}
