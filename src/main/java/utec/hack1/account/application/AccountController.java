package utec.hack1.account.application;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import utec.hack1.account.domain.Account;
import utec.hack1.account.domain.AccountService;
import utec.hack1.account.dto.UpdateUserDto;
import utec.hack1.auth.dto.UserInfoDto;

import java.security.Principal;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/private")
    public ResponseEntity<UserInfoDto> getPrivateInfo() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return ResponseEntity.ok(new UserInfoDto(principal.getUsername()));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserInfoDto> updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserDto request
    ) {
        Account updated = accountService.updateUser(
                id,
                request.getFirstName(),
                request.getLastName()
        );
        return ResponseEntity.ok(new UserInfoDto(updated.getUsername()));
    }

}
