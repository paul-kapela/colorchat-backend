package pl.paulkapela.colorchat.component.user.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.paulkapela.colorchat.component.user.dto.NewUser;
import pl.paulkapela.colorchat.component.user.model.User;

import java.time.ZonedDateTime;

public abstract class UserMapperDecorator implements UserMapper {

    @Autowired
    @Qualifier("delegate")
    private UserMapper delegate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User mapToNewUser(NewUser newUser) {
        if (newUser == null ) {
            return null;
        }

        User user = new User();

        user.setEmail(newUser.email());
        user.setUsername(newUser.username());
        user.setCreatedAt(ZonedDateTime.now());
        user.setPassword(passwordEncoder.encode(newUser.password()));

        return user;
    }
}
