package pl.paulkapela.colorchat.component.topic.model;

import lombok.Data;
import pl.paulkapela.colorchat.component.message.model.Message;
import pl.paulkapela.colorchat.component.user.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Data
public class Topic {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_generator")
    @SequenceGenerator(name = "topic_generator", sequenceName = "topic_id_seq", allocationSize = 1)
    private Long id;

    @NotNull
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private ZonedDateTime deletedAt;

    @ManyToMany
    @JoinTable(
            name = "topic_user",
            joinColumns = @JoinColumn(name = "topic_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

    @OneToMany
    @JoinColumn(name = "topic_id", updatable = false, insertable = false)
    private List<Message> messages;
}
