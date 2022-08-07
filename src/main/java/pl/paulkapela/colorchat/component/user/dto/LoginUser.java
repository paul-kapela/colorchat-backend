package pl.paulkapela.colorchat.component.user.dto;

import javax.validation.constraints.NotNull;

public record LoginUser (
        @NotNull
        String username,

        @NotNull
        String password
) {
}
