package project_structure.model_many_to_many.service.implementations;

import project_structure.model_many_to_many.model.User;
import project_structure.model_many_to_many.repository.RoleRepository;
import project_structure.model_many_to_many.repository.UserRepository;
import project_structure.model_many_to_many.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findByRoleName(String roleName) {
        return userRepository.findUsersByRolesName(roleName);
    }

    @Transactional
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public Long deleteById(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
