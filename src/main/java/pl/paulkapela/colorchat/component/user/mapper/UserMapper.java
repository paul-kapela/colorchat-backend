package pl.paulkapela.colorchat.component.user.mapper;

import org.mapstruct.Context;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.paulkapela.colorchat.component.profile.model.Profile;
import pl.paulkapela.colorchat.component.user.dto.NewUser;
import pl.paulkapela.colorchat.component.user.dto.UserDTO;
import pl.paulkapela.colorchat.component.user.model.User;

@Mapper(componentModel = "spring")
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper {

    User mapToNewUser(NewUser newUser);

    @Mapping(source = "profile.username", target = "username")
    @Mapping(source = "profile.description", target = "description")
    UserDTO mapToUserDTO(User user);
}

