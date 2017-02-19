package ru.kpfu.itis;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double firstNum = Double.parseDouble(req.getParameter("firstNum"));
        double secondNum = Double.parseDouble(req.getParameter("secondNum"));
        Operator operator = Operator.valueOf(req.getParameter("operator"));
        CalculatorService calculatorService = new CalculatorService();
        req.setAttribute("result", calculatorService.calculate(firstNum, secondNum, operator));
        RequestDispatcher reqDisp = req.getRequestDispatcher("/result.ftl");
        reqDisp.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
