package browserrequest.serversrc.server;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.HashMap;
import java.util.Properties;

public class ServerHandle extends Thread {
    // 单例模式
    private Socket socket;

    public ServerHandle(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        this.receiveRequest();
    }

    // 读取消息
    private void receiveRequest() {
        try {
            InputStream is = socket.getInputStream(); // socket字节流
            InputStreamReader isr = new InputStreamReader(is); // 字符流
            BufferedReader reader = new BufferedReader(isr);
            String contentAndParams = reader.readLine(); // resource/index.html?key=value
            this.parseContentAndParams(contentAndParams);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //解析 resource/index.html?key=value
    private void parseContentAndParams(String contentAndParams) {
        String content = null;
        HashMap<String, String> paramsMap = null;
        int index = contentAndParams.indexOf("?");
        if (index != -1) { // 带参数
            content = contentAndParams.substring(0, index);
            paramsMap = new HashMap<>();
            String params = contentAndParams.substring(index+1);
            String[] paramsArr = params.split("&");
            for (String prop:paramsArr){
                String[] KV = prop.split("=");
                paramsMap.put(KV[0],KV[1]);
            }
        } else {
            content = contentAndParams;
        }

        HttpServletRequest request = new HttpServletRequest(content, paramsMap);
        HttpServletResponse response = new HttpServletResponse();

        ServletController.findController(request, response);
        this.responseToBrowser(response);
    }


    //将最终的响应信息 写回浏览器
    private void responseToBrowser(HttpServletResponse response) {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println(response.getResponseContent());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
