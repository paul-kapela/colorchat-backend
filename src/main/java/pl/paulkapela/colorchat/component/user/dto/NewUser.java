package pl.paulkapela.colorchat.component.user.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public record NewUser(
        @Size(min = 3, max = 30)
        @Pattern(regexp = "[a-zA-Z\\d-_.]+")
        @NotNull
        String username,

        @Email
        @Size(max = 254)
        @NotNull
        String email,

        @Size(min = 8, max = 48)
        @NotNull
        String password
) {
}
