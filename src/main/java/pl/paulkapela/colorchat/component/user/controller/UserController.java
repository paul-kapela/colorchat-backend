package pl.paulkapela.colorchat.component.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.paulkapela.colorchat.component.user.dto.LoginUser;
import pl.paulkapela.colorchat.component.user.dto.NewUser;
import pl.paulkapela.colorchat.component.user.dto.UpdateUser;
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

    @GetMapping(path = "/users/{username}")
    public ResponseEntity<UserDTO> viewUserProfile(@PathVariable String username) {
        return userService.viewUserProfile(username);
    }

    @PutMapping(path = "/users")
    public ResponseEntity<UserDTO> editUserProfile(@Valid @RequestBody UpdateUser updateUser, Authentication authentication) {
        return userService.editUserProfile(updateUser, authentication);
    }
}
