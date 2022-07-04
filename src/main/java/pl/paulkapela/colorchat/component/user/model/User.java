package pl.paulkapela.colorchat.component.user.model;

import lombok.Data;
import pl.paulkapela.colorchat.component.message.model.Message;
import pl.paulkapela.colorchat.component.topic.model.Topic;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "user_")
@Data
public class User {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user__id_seq", allocationSize = 1)
    private Long id;

    @Email
    @Size(max = 254)
    @NotNull
    private String email;

    @Size(min = 3, max = 30)
    @NotNull
    private String username;

    @Size(max = 300)
    private String description;

    @NotNull
    private String password;

    @NotNull
    private ZonedDateTime createdAt;

    private ZonedDateTime deletedAt;

    @ManyToMany(mappedBy = "users")
    private List<Topic> topics;

    @OneToMany
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private List<Message> messages;
}
