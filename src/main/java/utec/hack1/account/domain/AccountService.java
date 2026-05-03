package utec.hack1.account.domain;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import utec.hack1.account.infrastructure.AccountRepository;

@Service
public class AccountService implements UserDetailsService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountRepository
                .findByEmail(username)
                .orElseThrow();
    }

    public Account updateUser(Long id, String username, String branch) {
        Account account = accountRepository.findById(id)
                .orElseThrow();
        account.setUsername(username);
        account.setBranch(branch);
        return accountRepository.save(account);
    }

}
