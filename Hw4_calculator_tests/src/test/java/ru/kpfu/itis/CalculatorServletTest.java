package ru.kpfu.itis;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.service.CalculatorService;
import ru.kpfu.itis.servlet.CalculatorServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.*;

public class CalculatorServletTest {
    private static HttpServletResponse response;
    private static HttpServletRequest request;
    private static RequestDispatcher dispatcher;
    private static CalculatorService calculatorService;
    private static PrintWriter printWriter;
    private static final String URI = "/calc/1+7.8";
    private static final String result = "8.8";
    private static final String METHOD_POST_ERROR = "Method is not allowed";
    private static CalculatorServlet calculatorServlet;

    @BeforeClass
    public static void setUp() throws ServletException, IOException {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
        printWriter = mock(PrintWriter.class);
        when(request.getRequestDispatcher("/result.ftl")).thenReturn(dispatcher);
        when(request.getRequestURI()).thenReturn(URI);
        when(response.getWriter()).thenReturn(printWriter);
        calculatorService = mock(CalculatorService.class);
        when(calculatorService.calculate(URI)).thenReturn(result);
        calculatorServlet = new CalculatorServlet(calculatorService);
    }

    @Test
    public void doGetShouldWorkCorrectly() throws ServletException, IOException {
        calculatorServlet.doGet(request, response);
        verify(request).getRequestURI();
        verify(request).setAttribute("result", result);
    }

    @Test
    public void doPostShouldSetStatus() throws ServletException, IOException {
        calculatorServlet.doPost(request, response);
        verify(response).setStatus(405);
        verify(response.getWriter()).print(METHOD_POST_ERROR);
    }
}
