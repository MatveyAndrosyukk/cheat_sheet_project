package project_structure.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project_structure.dto.AuthenticationRequest;
import project_structure.models.User;
import project_structure.repositories.UserRepository;
import project_structure.services.AuthenticationService;
import project_structure.services.MailService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    private final MailService mailService;

    @Override
    public void signIn(AuthenticationRequest authenticationRequest) {
        User userFromDB = userRepository.findByEmail(authenticationRequest.getEmail());

        if (userFromDB != null){
            throw new RuntimeException("User exists");
        }

        User userToSave = User.builder()
                .email(authenticationRequest.getEmail())
                .active(false)
                .activationCode(UUID.randomUUID().toString())
                .build();
        mailService.send(authenticationRequest.getEmail(),
                "Account Activation",
                String.format("Hello, %s. To activate your account, please, follow next link: http://localhost:8080/api/auth/activate/%s",
                        userToSave.getEmail(), userToSave.getActivationCode()));

        userRepository.save(userToSave);
    }

    @Override
    public void activate(String code) {
        User userFromDB = userRepository.findByActivationCode(code);

        if (userFromDB == null){
            throw new RuntimeException("Activation failed");
        }

        userFromDB.setActivationCode(null);
        userFromDB.setActive(true);

        userRepository.save(userFromDB);
    }
}
