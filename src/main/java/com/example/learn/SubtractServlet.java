package com.example.learn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SubtractServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the user input
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));

        // Perform subtraction
        int result = num1 - num2;

        // Store the result in the session
        HttpSession session = request.getSession();
        session.setAttribute("result", result);

        // Redirect to the result page
        response.sendRedirect("result.jsp");
    }
//    private void sendSuccessResponse(HttpServletResponse response, double result) throws IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h2>Subtraction Result:</h2>");
//        out.println("<p>Result: " + result + "</p>");
//        out.println("</body></html>");
//    }
//
//    private void sendErrorResponse(HttpServletResponse response, String message) throws IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h2>Error:</h2>");
//        out.println("<p>" + message + "</p>");
//        out.println("</body></html>");
//    }
}