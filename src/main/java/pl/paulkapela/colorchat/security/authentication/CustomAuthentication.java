package pl.paulkapela.colorchat.security.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public class CustomAuthentication extends UsernamePasswordAuthenticationToken {

    public CustomAuthentication(Object principal, Object credentials) {
        super(principal, credentials, Collections.emptyList());
    }
}
