package atmproject.dao;

import atmproject.domain.Atm;

import java.sql.*;

public class AtmDao {
    public Atm selectOne(String aname){
        String className = "com.mysql.cj.jdbc.Driver";
        String name = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/atm";
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        Atm atm = null;

        try {
            Class.forName(className);
            conn = DriverManager.getConnection(url,name,password);
            stat = conn.createStatement();
            rs = stat.executeQuery("SELECT ANAME, APASSWORD, ABALANCE FROM ATM WHERE ANAME = '"+ aname +"'");
            if(rs.next()){
                atm = new Atm();
                atm.setAname(rs.getString("aname"));
                atm.setApassword(rs.getString("apassword"));
                atm.setAbalance(rs.getFloat("abalance"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null){
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(stat!=null){
                    stat.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return atm;
    }

    public void update(Atm atm){
        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","123456");
            stat = conn.createStatement();
            String sql = "UPDATE ATM SET APASSWORD = '"+atm.getApassword()+"',ABALANCE = "+atm.getAbalance()+" WHERE ANAME = '"+atm.getAname()+"'";
            stat.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(stat!=null){
                    stat.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void insert(Atm atm){
        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","123456");
            stat = conn.createStatement();
            String sql = "INSERT INTO ATM VALUES('"+atm.getAname()+"','"+atm.getApassword()+"',"+atm.getAbalance()+")";
            stat.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(stat!=null){
                    stat.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public void delete(String name){
        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","123456");
            stat = conn.createStatement();
            String sql = "DELETE FROM ATM WHERE ANAME = '"+name+"'";
            stat.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(stat!=null){
                    stat.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
