package pl.paulkapela.colorchat.component.profile.model;

import lombok.Data;
import pl.paulkapela.colorchat.component.user.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;

    @Size(max = 300)
    private String description;
}
