package utec.hack1.auth.application;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utec.hack1.auth.domain.AuthService;
import utec.hack1.auth.dto.SignInRequest;
import utec.hack1.auth.dto.SignUpRequest;
import utec.hack1.auth.dto.TokenResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<TokenResponse> signUp(@RequestBody SignUpRequest request){
        return ResponseEntity.ok(authService.signUp(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<TokenResponse> signIn(@RequestBody SignInRequest request) {
        TokenResponse tokenResponse = authService.signIn(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(tokenResponse);
    }

}
