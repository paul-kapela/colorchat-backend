package pl.paulkapela.colorchat.component.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.paulkapela.colorchat.component.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
