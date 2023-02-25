package project_structure.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project_structure.models.User;
import project_structure.repositories.UserRepository;
import project_structure.services.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByActivationCode(String code) {
        return userRepository.findByActivationCode(code);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
