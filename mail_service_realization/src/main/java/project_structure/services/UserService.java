package project_structure.services;

import project_structure.models.User;

public interface UserService {
    User findByEmail(String email);
    User findByActivationCode(String code);
    User save(User user);
}
