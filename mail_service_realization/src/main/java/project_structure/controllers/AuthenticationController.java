package project_structure.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project_structure.dto.AuthenticationResponse;
import project_structure.dto.AuthenticationRequest;
import project_structure.services.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("singIn")
    public ResponseEntity<AuthenticationResponse> handleSignIn(@RequestBody AuthenticationRequest authenticationRequest){
        authenticationService.signIn(authenticationRequest);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("Activate your account in your email");
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(authenticationResponse);
    }

    @GetMapping("activate/{code}")
    public ResponseEntity<AuthenticationResponse> handleActivate(@PathVariable String code){
        authenticationService.activate(code);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("Your account has been successfully activated");
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(authenticationResponse);
    }
}
