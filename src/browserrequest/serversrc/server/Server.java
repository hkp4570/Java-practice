package browserrequest.serversrc.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void startServer(){
        try {
            System.out.println("启动服务器");
            int port = Integer.parseInt(ServerFileReader.getValue("port"));
            ServerSocket serverSocket = new ServerSocket(port);
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
