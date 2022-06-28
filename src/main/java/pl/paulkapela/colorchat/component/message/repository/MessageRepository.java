package pl.paulkapela.colorchat.component.message.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.paulkapela.colorchat.component.message.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
