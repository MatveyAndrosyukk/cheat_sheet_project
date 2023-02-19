package project_structure.controllers;

import project_structure.dto.AuthenticationRequest;
import project_structure.dto.AuthenticationResponse;
import project_structure.models.User;
import project_structure.services.AuthenticationService;
import project_structure.services.UserService;
import project_structure.utils.RolesToStringConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse> handleLogin(@RequestBody AuthenticationRequest requestDto) {
        String username = requestDto.getUsername();

        String token = authenticationService.login(requestDto);

        User user = userService.findByUsername(username);
        AuthenticationResponse response =
                new AuthenticationResponse(username, token, RolesToStringConverter.convert(user.getRoles()));
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PostMapping("signIn")
    public ResponseEntity<String> handleSignIn(@RequestBody AuthenticationRequest requestDto){
        authenticationService.register(requestDto);
        return ResponseEntity.ok()
                .body("Your account was successfully registered");
    }
}