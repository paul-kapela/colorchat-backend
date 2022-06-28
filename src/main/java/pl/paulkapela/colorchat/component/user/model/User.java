package pl.paulkapela.colorchat.component.user.model;

import lombok.Data;
import pl.paulkapela.colorchat.component.message.model.Message;
import pl.paulkapela.colorchat.component.profile.model.Profile;
import pl.paulkapela.colorchat.component.topic.model.Topic;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Email
    @Size(max = 254)
    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private ZonedDateTime createdAt;

    private ZonedDateTime deletedAt;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private Profile profile;

    @ManyToMany(mappedBy = "users")
    private List<Topic> topics;

    @OneToMany
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private List<Message> messages;
}
