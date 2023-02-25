package project_structure.services.implementations;

import project_structure.dto.AuthenticationRequest;
import project_structure.jwt.JwtTokenProvider;
import project_structure.models.Role;
import project_structure.models.User;
import project_structure.models.enums.Status;
import project_structure.repositorys.RoleRepository;
import project_structure.services.AuthenticationService;
import project_structure.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public String login(AuthenticationRequest requestDto) {
        try {
            String username = requestDto.getUsername();
            String password = requestDto.getPassword();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            User user = userService.findByUsername(username);

            return jwtTokenProvider.createToken(username, user.getRoles());
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @Override
    public void register(AuthenticationRequest requestDto) {
        User userFromDB = userService.findByUsername(requestDto.getUsername());

        if (userFromDB != null){
            throw  new RuntimeException("User exists");
        }


        Role roleUser = roleRepository.findByName("ROLE_USER");

        if (roleUser == null){
            roleUser = new Role("ROLE_USER");
        }

        User user = User.builder()
                .username(requestDto.getUsername())
                .firstName("")
                .lastName("")
                .email("")
                .status(Status.ACTIVE)
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .roles(List.of(roleUser))
                .build();

        userService.save(user);
    }

}