package pl.paulkapela.colorchat.component.message.model;

import lombok.Data;
import pl.paulkapela.colorchat.component.topic.model.Topic;
import pl.paulkapela.colorchat.component.user.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;

@Entity
@Data
public class Message {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Size(max = 20000)
    @NotNull
    private String content;

    @NotNull
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private ZonedDateTime readAt;
    private ZonedDateTime deletedAt;
}
