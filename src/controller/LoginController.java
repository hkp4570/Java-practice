package controller;

import service.AtmService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    AtmService atmService = new AtmService();
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String aname = request.getParameter("aname");
        String apassword = request.getParameter("apassword");
        String rs = atmService.loginService(aname,apassword);
        System.out.println(rs);
    }
}
