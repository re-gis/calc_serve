package com.example.learn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SubtractServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num1Str = (String) request.getAttribute("num1");
        System.out.println("sub");
        String num2Str = (String) request.getAttribute("num2");

        try {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);

            double result = num1 - num2;

            sendSuccessResponse(response, result);
        } catch (NumberFormatException e) {
            sendErrorResponse(response, "Invalid number format");
        }
    }

    private void sendSuccessResponse(HttpServletResponse response, double result) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Subtraction Result:</h2>");
        out.println("<p>Result: " + result + "</p>");
        out.println("</body></html>");
    }

    private void sendErrorResponse(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Error:</h2>");
        out.println("<p>" + message + "</p>");
        out.println("</body></html>");
    }
}