package pl.paulkapela.colorchat.component.user.dto;

import java.time.ZonedDateTime;

public record UserDTO(
        String username,
        String description,
        ZonedDateTime createdAt
) {
}
