package project_structure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AuthenticationResponse {
    private String username;

    private String token;

    private List<String> roles;
}
