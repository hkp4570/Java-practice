package unionpaging.dao;

import unionpaging.domain.Area;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AreaDao {
    public ArrayList<String> select1(){
        ArrayList<String> list = new ArrayList();
        String className = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";
        String sql = "select distinct aname from area a \n" +
                "inner join city ci on a.aid = ci.aid \n" +
                "where ci.citysize between 1000 and 2000";

        try {
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                list.add(rs.getString("aname"));
            }
            rs.close();
            stat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
