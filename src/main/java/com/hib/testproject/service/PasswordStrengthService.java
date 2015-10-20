package com.hib.testproject.service;

public interface PasswordStrengthService {
    public String getPasswordStrength(String password);
    public boolean isNotPasswordStrong(String password);
}
