package pl.paulkapela.colorchat.component.topic.dto;

import pl.paulkapela.colorchat.component.topic.model.TopicType;
import pl.paulkapela.colorchat.component.user.model.User;

import javax.validation.constraints.NotNull;
import java.util.Set;

public record NewTopic(
        @NotNull
        TopicType type,

        Set<User> users
) {
}
