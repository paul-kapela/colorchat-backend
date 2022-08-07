package pl.paulkapela.colorchat.component.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.paulkapela.colorchat.component.user.dto.CustomUserDetails;
import pl.paulkapela.colorchat.component.user.model.User;
import pl.paulkapela.colorchat.component.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
            new UsernameNotFoundException("User not found by this username")
        );

        return new CustomUserDetails(user);
    }
}
