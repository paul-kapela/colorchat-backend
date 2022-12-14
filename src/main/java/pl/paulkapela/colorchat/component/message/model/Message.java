package pl.paulkapela.colorchat.component.message.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;

@Entity
@Data
public class Message {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_generator")
    @SequenceGenerator(name = "message_generator", sequenceName = "message_id_seq", allocationSize = 1)
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
