package pl.paulkapela.colorchat.component.user.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import pl.paulkapela.colorchat.component.user.dto.NewUser;
import pl.paulkapela.colorchat.component.user.dto.UserDTO;
import pl.paulkapela.colorchat.component.user.model.User;

@Mapper(componentModel = "spring")
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper {

    User mapToNewUser(NewUser newUser);

    UserDTO mapToUserDTO(User user);
}

