package unionpaging.test;

import unionpaging.service.AreaService;

import java.util.ArrayList;

public class AreaMain {
    public static void main(String[] args){
        AreaService areaService = new AreaService();
        ArrayList<String> list = areaService.whereArea();
        for (String a:list){
            System.out.println(a);
        }
    }

}
