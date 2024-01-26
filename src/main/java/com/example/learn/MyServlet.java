package com.example.learn;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/M")
public class MyServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Hello init");
        super.init(config);
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs)throws ServletException, IOException{}
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException{
        rs.setContentType("text/html");
        PrintWriter out = rs.getWriter();

        ServletConfig config = getServletConfig();
        String driver=config.getInitParameter("driverName");
        out.print("<h1>JDBC Driver Name is: "+driver+"</h1>");
        out.close();
    }
}