package project_structure.services;

import project_structure.dto.AuthenticationRequest;

public interface AuthenticationService {
    String login(AuthenticationRequest requestDto);
    void register(AuthenticationRequest requestDto);
}