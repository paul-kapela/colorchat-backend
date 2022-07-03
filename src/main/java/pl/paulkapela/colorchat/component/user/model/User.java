package pl.paulkapela.colorchat.component.user.model;

import lombok.Data;
import pl.paulkapela.colorchat.component.message.model.Message;
import pl.paulkapela.colorchat.component.profile.model.Profile;
import pl.paulkapela.colorchat.component.topic.model.Topic;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_id_seq", allocationSize = 1)
    private Long id;

    private String email;

    private String password;

    private ZonedDateTime createdAt;

    private ZonedDateTime deletedAt;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private Profile profile;

    @ManyToMany(mappedBy = "users")
    private List<Topic> topics;

    @OneToMany
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private List<Message> messages;
}
