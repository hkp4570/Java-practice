package atmproject.service;

import atmproject.domain.Atm;
import atmproject.dao.AtmDao;

public class AtmService {
    AtmDao dao = new AtmDao();
    public String login(String name, String password){
        Atm atm = dao.selectOne(name);
        if(atm!=null && atm.getApassword().equals(password)){
            return "登录成功";
        }
        return "用户名或密码错误";
    }
//    查询
    public Float queryMoney(String name){
        Atm atm = dao.selectOne(name);
        return atm.getAbalance();
    }
//    存款
    public void deposit(String name, Float money){
        Atm atm = dao.selectOne(name);
        atm.setAbalance(atm.getAbalance() + money);
        dao.update(atm);
    }
//    取款
    public void withdrawMoney(String name, Float money){
        Atm atm = dao.selectOne(name);
        if(atm.getAbalance() >= money){
            atm.setAbalance(atm.getAbalance() - money);
            dao.update(atm);
        }else{
            System.out.println("余额不足");
        }
    }
//    转账
    public void transfer(String outName, String inName, Float money){
        Atm outAtm = dao.selectOne(outName);
        Atm inAtm = dao.selectOne(inName);
        if(outAtm.getAbalance() >= money){
            outAtm.setAbalance(outAtm.getAbalance() - money);
            inAtm.setAbalance(inAtm.getAbalance() + money);
            dao.update(outAtm);
            dao.update(inAtm);
        }else{
            System.out.println("余额不足");
        }
    }
//    开户
    public void open(String name, String password, Float balance){
        dao.insert(new Atm(name, password, balance));
    }
//    销户
    public void del(String name){
        Atm atm = dao.selectOne(name);
        if(atm!=null){
            dao.delete(name);
        }
    }
}
