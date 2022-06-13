package unionpaging.service;

import unionpaging.dao.AreaDao;

import java.util.ArrayList;

public class AreaService {
    AreaDao dao = new AreaDao();
    public ArrayList<String> whereArea(){
        return dao.select1();
    }
}
