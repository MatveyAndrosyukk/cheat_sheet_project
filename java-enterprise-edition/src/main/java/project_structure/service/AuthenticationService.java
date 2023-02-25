package project_structure.service;

public interface AuthenticationService {
    boolean isAuthenticated(String username, String password);
}
