package com.hib.testproject.service.impl;

import com.hib.testproject.service.PasswordStrengthService;
import com.hib.testproject.util.PasswordStrengths;

public class PasswordStrengthServiceImpl implements PasswordStrengthService {
    @Override
    public String getPasswordStrength(String password) {
        if (password == null) {
            return PasswordStrengths.NONE.getValue();
        } else if (password.length() <= 4) {
            return PasswordStrengths.WEAK.getValue();
        } else if (password.length() < 8) {
            return PasswordStrengths.MEDIUM.getValue();
        } else {
            return PasswordStrengths.STRONG.getValue();
        }
    }

    @Override
    public boolean isNotPasswordStrong(String password) {
        if (getPasswordStrength(password).equals(PasswordStrengths.STRONG.getValue())) {
            return false;
        }
        return true;

    }
}
