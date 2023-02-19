package project_structure.model_many_to_many.service;

import project_structure.model_many_to_many.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    List<User> findByRoleName(String roleName);

    User save(User user);

    Long deleteById(Long id);
}
