package com.tytarenko.service;

/**
 * Service for security.
 *
 * @author Vladyslav Tytarenko
 * @version 1.0
 */

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String login, String password);
}
