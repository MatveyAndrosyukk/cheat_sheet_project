package project_structure.services;

import project_structure.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findByUsername(String username);

    User findById(Long id);

    User save(User user);

    Long deleteById(Long id);
}
