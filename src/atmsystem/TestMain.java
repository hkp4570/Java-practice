package atmsystem;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args){
        AtmService atmService = new AtmService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎您使用银行自助服务系统\n请输入账号:");
        String name = scanner.nextLine();
        System.out.println("请输入密码:");
        String password = scanner.nextLine();
        String loginResult = atmService.login(name, password);
        if(loginResult.equals("登录成功")){
            System.out.println("恭喜您登录成功，请您输入操作项");
            System.out.println("查询请输入1\n存款请输入2\n取款请输入3\n转账请输入4\n退出请输入5\n如需帮助请拨打电话1234567890");
            String option= scanner.nextLine();
            switch (option){
                case "1":
                    Float balance = atmService.queryBalance(name);
                    System.out.println("尊敬的"+name+",您的账户余额为"+balance);
                    break;
                case "2":
                    Float money = scanner.nextFloat();
                    atmService.deposit(name,money);
                    break;
            }
        }else{
            System.out.println(loginResult);
        }
    }
}
