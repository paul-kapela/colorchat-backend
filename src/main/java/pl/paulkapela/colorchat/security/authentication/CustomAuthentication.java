package pl.paulkapela.colorchat.security.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;

public class CustomAuthentication extends UsernamePasswordAuthenticationToken {

    public CustomAuthentication(Object principal, Object credentials) {
        super(principal, credentials, Collections.emptyList());
    }
}
