package utec.hack1.auth.domain;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import utec.hack1.account.domain.Account;
import utec.hack1.account.domain.Role;
import utec.hack1.account.infrastructure.AccountRepository;
import utec.hack1.auth.components.JwtService;
import utec.hack1.auth.dto.SignUpRequest;
import utec.hack1.auth.dto.TokenResponse;

@Service
public class AuthService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(AccountRepository accountRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public TokenResponse signUp(SignUpRequest request){
        Account account = accountRepository.save(
                new Account(
                        request.getEmail(),
                        passwordEncoder.encode(request.getPassword()),
                        request.getFirstName(),
                        request.getLastName(),
                        Role.ROLE_USER
                )
        );
        var token = jwtService.generateToken(account);
        return new TokenResponse(token);
    }

    public TokenResponse signIn(String username, String password){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );
        var account = accountRepository.findByEmail(username).orElseThrow();
        var token = jwtService.generateToken(account);
        return new TokenResponse(token);
    }
}
