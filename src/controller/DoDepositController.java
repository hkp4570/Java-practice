package controller;

import service.AtmService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoDepositController extends HttpServlet {
    AtmService atmService = new AtmService();
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("dodeposit");
        String abalance = request.getParameter("abalance");
        String aname = request.getParameter("aname");
        System.out.println(aname);
        System.out.println(abalance);
        atmService.deposit(aname, new Float(abalance));
        request.getRequestDispatcher("welcome.jsp").forward(request,response);
    }
}
