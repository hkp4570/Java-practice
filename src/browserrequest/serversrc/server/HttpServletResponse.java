package browserrequest.serversrc.server;

public class HttpServletResponse {
//    存储响应信息
    private StringBuilder responseContent = new StringBuilder();

    public StringBuilder getResponseContent() {
        return responseContent;
    }

    public void write(String str){
        this.responseContent.append(str);
    }
}
