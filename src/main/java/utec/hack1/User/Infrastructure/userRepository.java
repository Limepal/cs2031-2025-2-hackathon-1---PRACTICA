package utec.hack1.User.Infrastructure;

import utec.hack1.User.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, Long> {
}
