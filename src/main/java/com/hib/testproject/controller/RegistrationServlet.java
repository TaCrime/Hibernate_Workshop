package com.hib.testproject.controller;

import com.hib.testproject.model.Credential;
import com.hib.testproject.service.RegisterService;
import com.hib.testproject.util.ApplicationContextProvider;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private RegisterService registerService = (RegisterService) ApplicationContextProvider
            .getApplicationContext().getBean("registerService");

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {

        String output = "";
        RequestDispatcher requestDispatcher = null;
        try {
            output = tryToRegister(request.getParameter("login"), request.getParameter("password"));
            requestDispatcher = request.getRequestDispatcher("/login.html");
        } catch (Exception e) {
            output = buildHTMLResponse(false, e.getMessage());
            requestDispatcher = request.getRequestDispatcher( "/registration.html");
        }
        PrintWriter out = response.getWriter();
        out.println(output);
        requestDispatcher.include(request, response);

    }

    private String tryToRegister(String login, String password) throws Exception {
        Credential credential = new Credential(StringUtils.trim(login), StringUtils.trim(password));
        boolean result = registerService.register(credential);
        return buildHTMLResponse(result);
    }

    private String buildHTMLResponse(boolean result) {
        return buildHTMLResponse(result, "");
    }

    private String buildHTMLResponse(boolean result, String reason ) {
        if (result) {
            return String.format("<font color=%s>Registered %s.%s</font>\n", "green","successfully", reason);
        } else {
            return String.format("<font color=%s>Registered %s.%s</font>\n", "red","unsuccessfully", reason);
        }
    }
}
