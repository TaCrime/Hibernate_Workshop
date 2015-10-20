package com.hib.testproject.controller;

import com.hib.testproject.service.PasswordStrengthService;
import com.hib.testproject.util.ApplicationContextProvider;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PasswordStrenghtServlet")
public class PasswordStrenghtServlet extends HttpServlet {

    private PasswordStrengthService passwordStrengthService = (PasswordStrengthService) ApplicationContextProvider
            .getApplicationContext().getBean("passwordStrengthService");

    public void doGet(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        String password = request.getParameter("password");
        response.setContentType("text/html");
        response.getWriter().write(passwordStrengthService.getPasswordStrength(StringUtils.trim(password)));
    }
}
