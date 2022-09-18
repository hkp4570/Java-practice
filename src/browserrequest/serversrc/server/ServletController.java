package browserrequest.serversrc.server;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class ServletController {

//    配置文件web.properties的内容缓存
    private static HashMap<String, String> controllerNameMap = new HashMap<>();
    private static HashMap<String, HttpServlet> controllerObjectMap = new HashMap<>();

    static {
        try{
            Properties pro = new Properties();
            pro.load(new FileReader("src//browserrequest//serversrc//web.properties"));
            Enumeration en = pro.propertyNames();
            while(en.hasMoreElements()){
                String content = (String) en.nextElement();
                String realControllerName = pro.getProperty(content);
                controllerNameMap.put(content, realControllerName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void findController(HttpServletRequest request, HttpServletResponse response){
        String content = request.getContent();
        try{
            HttpServlet controllerObject = controllerObjectMap.get(content);
            if(controllerObject==null){
                String realControllerName = controllerNameMap.get(content);
                if(realControllerName!=null){
                    Class clazz = Class.forName(realControllerName);
                    controllerObject = (HttpServlet) clazz.newInstance();
                    controllerObjectMap.put(content,controllerObject);
                }
            }
            Class controllerClass = controllerObject.getClass();
//            ???
            Method serviceMethod = null;
            serviceMethod = controllerClass.getMethod("service", HttpServletRequest.class, HttpServletResponse.class);
            serviceMethod.invoke(controllerObject,request,response);

        }catch (ClassNotFoundException e){
            response.write("请求的"+content+"Controller不存在");
        }catch (NoSuchMethodException e){
            response.write("405 没有可以执行的方法");
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
