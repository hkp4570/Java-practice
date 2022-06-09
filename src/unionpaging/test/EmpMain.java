package unionpaging.test;

import unionpaging.domain.Emp;
import unionpaging.service.EmpService;

import java.util.ArrayList;

public class EmpMain {
    public static void main(String[] args){
        EmpService empService = new EmpService();
//        ArrayList<Emp> list = empService.paging(2);
        ArrayList<Emp> list = empService.like("A");
        for (Emp e:list){
            System.out.println(e);
        }
    }
}
