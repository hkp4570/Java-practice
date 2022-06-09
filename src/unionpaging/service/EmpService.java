package unionpaging.service;

import unionpaging.dao.EmpDao;
import unionpaging.domain.Emp;

import java.util.ArrayList;

public class EmpService {
    EmpDao empDao = new EmpDao();
    public ArrayList<Emp> paging(int limit){
        return empDao.paging((limit - 1) * 5);
    }
    public ArrayList<Emp> like(String value){
        return empDao.queryLike(value);
    }
}
