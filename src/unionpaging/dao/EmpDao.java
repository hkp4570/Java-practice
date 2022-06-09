package unionpaging.dao;

import unionpaging.domain.Emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpDao {
    String className = "com.mysql.cj.jdbc.Driver";
    String user = "root";
    String password = "123456";
    String url = "jdbc:mysql://localhost:3306/test";

//    模糊查询
    public ArrayList<Emp> queryLike(String value){
        ArrayList<Emp> list = new ArrayList();
        String sql = "select * from emp where ename like ?";
        try {
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,"%" + value + "%");
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                Emp emp = new Emp();
                emp.setEmpno(rs.getInt("empno"));
                emp.setEname(rs.getString("ename"));
                emp.setJob(rs.getString("job"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setHiredate(rs.getDate("hiredate"));
                emp.setSal(rs.getFloat("sal"));
                emp.setComm(rs.getFloat("comm"));
                emp.setEmpno(rs.getInt("deptno"));
                list.add(emp);
            }
            rs.close();
            stat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
//    分页查询
    public ArrayList<Emp> paging(int limit){
        String sql = "select * from emp limit ?, 5;";
        ArrayList<Emp> list = new ArrayList();
        try {
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, limit);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                Emp emp = new Emp();
                emp.setEmpno(rs.getInt("empno"));
                emp.setEname(rs.getString("ename"));
                emp.setJob(rs.getString("job"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setHiredate(rs.getDate("hiredate"));
                emp.setSal(rs.getFloat("sal"));
                emp.setComm(rs.getFloat("comm"));
                emp.setEmpno(rs.getInt("deptno"));
                list.add(emp);
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
