package com.hib.testproject.service;

import com.hib.testproject.model.Credential;

public interface RegisterService {

    public boolean register(Credential credential) throws Exception;
    public boolean ifCredentialExists(Credential credential) throws Exception;
}
