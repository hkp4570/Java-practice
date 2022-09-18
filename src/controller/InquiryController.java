package controller;

import service.AtmService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InquiryController extends HttpServlet {
    AtmService atmService = new AtmService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String aname = request.getParameter("aname");
        Float abalance = atmService.inquiry(aname);
        request.setAttribute("abalance", abalance);
        RequestDispatcher rq = request.getRequestDispatcher("inquiry.jsp");
        rq.forward(request,response);
    }
}
