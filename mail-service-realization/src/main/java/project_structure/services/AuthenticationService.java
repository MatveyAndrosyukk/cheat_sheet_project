package project_structure.services;

import project_structure.dto.AuthenticationRequest;

public interface AuthenticationService {
    void signIn(AuthenticationRequest authenticationRequest);
    void activate(String code);
}
