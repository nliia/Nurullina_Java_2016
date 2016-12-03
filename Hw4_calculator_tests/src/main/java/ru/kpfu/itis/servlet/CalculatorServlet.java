package ru.kpfu.itis.servlet;

import ru.kpfu.itis.service.CalculatorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculatorServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        CalculatorService calculatorService = new CalculatorService();
        String result = calculatorService.calculate(uri);
        req.setAttribute("result", result);
        RequestDispatcher reqDisp = req.getRequestDispatcher("/result.ftl");
        reqDisp.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(405);
        resp.getWriter().print("Method is not allowed");
    }
}
