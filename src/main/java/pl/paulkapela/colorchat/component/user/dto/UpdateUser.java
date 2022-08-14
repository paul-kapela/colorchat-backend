package pl.paulkapela.colorchat.component.user.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public record UpdateUser(
    @Size(min = 3, max = 30)
    @Pattern(regexp = "[a-zA-Z\\d-_.]+")
    @NotNull
    String username,

    @Size(max = 300)
    String description
) {
}
