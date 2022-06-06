package atmproject.test;

import atmproject.service.AtmService;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args){
        AtmService atmService = new AtmService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        String result = atmService.login(name,password);
        System.out.println(result);
        while(true){
            System.out.println("查询请输入1;存款请输入2;取款请输入3;转账请输入4;开户请输入5;销户请输入6;退出请输入0");
            String input = scanner.nextLine();
            if(input.equals("0")){
                break;
            }
            switch (input){
                case "1":
                    Float money = atmService.queryMoney(name);
                    System.out.println("剩余"+money);
                    break;
                case "2":
                    System.out.println("请输入存款金额");
                    Float depositMoney = scanner.nextFloat();
                    atmService.deposit(name, depositMoney);
                    break;
                case "3":
                    System.out.println("请输入取款金额");
                    Float withdrawMoney = scanner.nextFloat();
                    atmService.withdrawMoney(name, withdrawMoney);
                    break;
                case "4":
                    System.out.println("请输入转账用户");
                    String tu = scanner.nextLine();
                    System.out.println("请输入转账金额");
                    Float tm = scanner.nextFloat();
                    atmService.transfer(name,tu,tm);
                    break;
            }
        }
    }
}
