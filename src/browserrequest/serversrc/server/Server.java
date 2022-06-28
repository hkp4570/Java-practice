package browserrequest.serversrc.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void startServer(){
        try {
            System.out.println("启动服务器");
            ServerSocket serverSocket = new ServerSocket(9999);
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println(socket + "socket");
                new ServerHandle(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
