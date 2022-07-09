package service;

import dao.AtmDao;
import domain.Atm;

public class AtmService {
    AtmDao dao = new AtmDao();
    public String loginService(String aname, String apassword){
        Atm atm = dao.selectOne(aname);
        if(atm!=null && atm.getApassword().equals(apassword)){
            return "登录成功";
        }
        return "用户名或密码错误";
    }
}
