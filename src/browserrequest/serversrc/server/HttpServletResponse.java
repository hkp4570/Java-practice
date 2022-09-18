package browserrequest.serversrc.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class HttpServletResponse {
//    存储响应信息
    private StringBuilder responseContent = new StringBuilder();

    public StringBuilder getResponseContent() {
        return responseContent;
    }

    public void write(String str){
        this.responseContent.append(str);
    }

    public void sendRedirect(String path){
        try {
            File file = new File("src//browserrequest//serversrc//file//" + path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String value = br.readLine();
            while(value!=null){
                responseContent.append(value);
                value = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
