package pl.paulkapela.colorchat.component.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.paulkapela.colorchat.component.user.dto.NewUser;
import pl.paulkapela.colorchat.component.user.dto.UserDTO;
import pl.paulkapela.colorchat.component.user.mapper.UserMapper;
import pl.paulkapela.colorchat.component.user.model.User;
import pl.paulkapela.colorchat.component.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public ResponseEntity<UserDTO> createNewUser(NewUser newUser) {
        User createdUser = userRepository.save(userMapper.mapToNewUser(newUser));

        return ResponseEntity.ok().body(userMapper.mapToUserDTO(createdUser));
    }
}
