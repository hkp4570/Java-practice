package atmsystem;

public class AtmService {
   private AtmDao dao = new AtmDao();

   public String login(String name, String password){
       User user = dao.selectOne(name);
       if(user!=null && user.getPassword().equals(password)){
           return "登录成功";
       }
       return "用户名或密码错误";
   }
//   查询余额
   public Float queryBalance(String name){
       User user = dao.selectOne(name);
       return user.getBalance();
   }
//   存款
    public void deposit(String name, Float money){
       User user = dao.selectOne(name);
       user.setBalance(user.getBalance() + money);
       dao.update(user);
    }
//   取款
    public void withdrawal(String name, Float money){
       User user = dao.selectOne(name);
       if(user.getBalance() >= money){
           user.setBalance(user.getBalance() - money);
           dao.update(user);
       }else{
           System.out.println("余额不足");
       }
    }
//    转账
    public void transfer(String outName,String inName,Float transferMoney){
        User outUser = dao.selectOne(outName);
        if(outUser.getBalance()>transferMoney){
            User inUser = dao.selectOne(inName);
            if(inUser!=null){//转入账户是存在的
                outUser.setBalance(outUser.getBalance()-transferMoney);
                inUser.setBalance(inUser.getBalance()+transferMoney);
                dao.update(outUser);
            }else{
                System.out.println("对不起,您输入的转入账户不存在");
            }
        }else{
            System.out.println("对不起"+outName+",您的账户余额不足");
        }
    }
}
