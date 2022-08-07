package pl.paulkapela.colorchat.component.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.paulkapela.colorchat.component.user.dto.LoginUser;
import pl.paulkapela.colorchat.component.user.dto.NewUser;
import pl.paulkapela.colorchat.component.user.dto.UserDTO;
import pl.paulkapela.colorchat.component.user.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<UserDTO> createNewUser(@Valid @RequestBody NewUser newUser) {
        return userService.createNewUser(newUser);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<UserDTO> authenticateUser(@Valid @RequestBody LoginUser loginUser) {
        return userService.authenticateUser(loginUser);
    }
}
