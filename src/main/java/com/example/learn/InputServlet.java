package com.example.learn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/getInput")
public class InputServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");
        String operation = request.getParameter("operation");
        System.out.println(num1Str);

        request.setAttribute("num1", num1Str);
        request.setAttribute("num2", num2Str);

        if ("add".equals(operation)) {
            request.getRequestDispatcher("/AddServlet").forward(request, response);
        } else if ("subtract".equals(operation)) {
            request.getRequestDispatcher("/SubtractServlet").forward(request, response);
        } else {
            sendErrorResponse(response, "Invalid operation.");
        }
    }

    private void sendErrorResponse(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body><h2>Error:</h2><p>" + message + "</p></body></html>");
    }
}
