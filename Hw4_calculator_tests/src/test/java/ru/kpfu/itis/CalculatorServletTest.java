package ru.kpfu.itis;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.servlet.CalculatorServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculatorServletTest {
    private static HttpServletResponse response;
    private static HttpServletRequest request;
    private static RequestDispatcher dispatcher;

    @BeforeClass
    public static void setUp() throws ServletException, IOException {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("/result.ftl")).thenReturn(dispatcher);
        when(request.getRequestURI()).thenReturn("/calc/1+7.8");
    }

    @Test
    public void doGetShouldWorkCorrectly() throws ServletException, IOException {
        new CalculatorServlet().doGet(request, response);
        verify(request).getRequestURI();
        verify(request).setAttribute("result", "8.8");
    }

    @Test
    public void doPostShouldSetStatus() throws ServletException, IOException {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        when(response.getWriter()).thenReturn(pw);
        new CalculatorServlet().doPost(request, response);
        verify(response).setStatus(405);
        String result = sw.getBuffer().toString().trim();
        assertEquals("Method is not allowed", result);
    }
}
