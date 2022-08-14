package pl.paulkapela.colorchat.component.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.paulkapela.colorchat.component.user.dto.*;
import pl.paulkapela.colorchat.component.user.mapper.UserMapper;
import pl.paulkapela.colorchat.component.user.model.User;
import pl.paulkapela.colorchat.component.user.repository.UserRepository;
import pl.paulkapela.colorchat.security.util.TokenUtil;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CustomUserDetailService userDetailService;
    private final AuthenticationManager authenticationManager;
    private final TokenUtil tokenUtil;

    public ResponseEntity<UserDTO> createNewUser(NewUser newUser) {
        User createdUser = userRepository.save(userMapper.mapToNewUser(newUser));

        LoginUser loginUser = userMapper.mapToLoginUser(newUser);

        return authenticate(loginUser);
    }

    public ResponseEntity<UserDTO> authenticateUser(LoginUser loginUser) throws BadCredentialsException {
        return authenticate(loginUser);
    }

    @Transactional
    public ResponseEntity<UserDTO> editUserProfile(UpdateUser updateUser, Authentication authentication) throws UsernameNotFoundException {
        String username = authentication.getName();

        User userEdited = userRepository.findByUsername(username).orElseThrow(() ->
            new UsernameNotFoundException("User not found by username")
        );

        userEdited.setUsername(updateUser.username());
        userEdited.setDescription(updateUser.description());

        UserDTO userEditedDTO = userMapper.mapToUserDTO(userEdited);

        return ResponseEntity.ok().body(userEditedDTO);
    }

    private ResponseEntity<UserDTO> authenticate(LoginUser loginUser) {
        UsernamePasswordAuthenticationToken authenticationRequest = new UsernamePasswordAuthenticationToken(loginUser.username(), loginUser.password());

        try {
            authenticationManager.authenticate(authenticationRequest);
        } catch (BadCredentialsException exception) {
            throw new BadCredentialsException("Incorrect username or password", exception);
        }

        CustomUserDetails userDetails = userDetailService.loadUserByUsername(loginUser.username());

        String token = tokenUtil.generateToken(userDetails);
        User authenticatedUser = userDetails.getUser();

        UserDTO authenticatedUserDTO = userMapper.mapToUserDTO(authenticatedUser);

        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", token)).body(authenticatedUserDTO);
    }
}
