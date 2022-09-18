package browserrequest.serversrc.server;

import java.io.FileReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class ServerFileReader {

    private static HashMap<String, String> map = new HashMap<>();

    static {
        try {
            Properties pro = new Properties();
            pro.load(new FileReader("src//browserrequest//serversrc//server.properties"));
            Enumeration en = pro.propertyNames();
            while(en.hasMoreElements()){
                String name = (String) en.nextElement();
                map.put(name,pro.getProperty(name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key){
        return map.get(key);
    }
}
