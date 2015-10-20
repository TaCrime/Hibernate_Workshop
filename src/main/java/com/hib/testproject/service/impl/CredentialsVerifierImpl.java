package com.hib.testproject.service.impl;

import com.hib.testproject.model.Credential;
import com.hib.testproject.service.CredentialsService;
import com.hib.testproject.service.CredentialsVerifier;

public class CredentialsVerifierImpl implements CredentialsVerifier {
    private CredentialsService credentialsService;
    @Override
    public boolean isValidCreadential(String login, String password) {
        Credential credential = credentialsService.getUserByLogin(login);
        if (credential != null && credential.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public void setCredentialsService(CredentialsService credentialsService) {
        this.credentialsService = credentialsService;
    }
}
