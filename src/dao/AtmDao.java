package dao;

import domain.Atm;

import java.sql.*;

public class AtmDao {
    String className = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/atm";
    String user = "root";
    String password = "123456";
    public Atm selectOne(String aname){
        Atm atm = null;
        String sql = "SELECT * FROM ATM WHERE ANAME = ?";
        try {
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement state = conn.prepareStatement(sql);
            state.setString(1,aname);
            ResultSet rs = state.executeQuery();
            if(rs.next()){
                atm = new Atm();
                atm.setAname(rs.getString("aname"));
                atm.setApassword(rs.getString("apassword"));
                atm.setAbalance(rs.getFloat("abalance"));
            }
            rs.close();
            state.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return atm;
    }
    public void update(Atm atm){
        String sql = "UPDATE ATM SET APASSWORD = ? , ABALANCE = ? WHERE ANAME = ?";
        try {
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, atm.getApassword());
            statement.setFloat(2, atm.getAbalance());
            statement.setString(3,atm.getAname());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
