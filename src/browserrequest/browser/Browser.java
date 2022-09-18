package browserrequest.browser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Browser {
    private Socket socket;
    Scanner input = new Scanner(System.in);

    // 打开浏览器
    public void openBrowser() {
        System.out.println("url:");
        // ip:9999/resource/index.html?key=value&key=value
        String url = input.nextLine();
        this.parseURL(url);
    }

    // 解析url
    private void parseURL(String url) {
        int ipIndex = url.indexOf(':');
        int portIndex = url.indexOf("/");
        String ip = url.substring(0, ipIndex);
        int port = Integer.parseInt(url.substring(ipIndex + 1, portIndex));
        String contentAndParams = url.substring(portIndex + 1);
        this.createSocketAndSendRequest(ip, port, contentAndParams);
    }

    // 创建socket发送请求
    private void createSocketAndSendRequest(String ip, int port, String contentAndParams) {
        try {
            // 通过ip和port创建socket链接
            socket = new Socket(ip,port);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println(contentAndParams);
            out.flush();
            this.receiveResponseContent();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void receiveResponseContent(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String responseContent = reader.readLine();
            this.parseResponseContentAndShow(responseContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void parseResponseContentAndShow(String responseContent){
        System.out.println(responseContent);
    };
}
