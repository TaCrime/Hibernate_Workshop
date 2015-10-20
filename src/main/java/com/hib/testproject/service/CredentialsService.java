package com.hib.testproject.service;

import com.hib.testproject.model.Credential;

/**
 * Created with IntelliJ IDEA.
 * User: Пользователь
 * Date: 17.10.15
 * Time: 12:41
 * To change this template use File | Settings | File Templates.
 */
public interface CredentialsService {

    public Credential getUserByLogin(String login);
}
