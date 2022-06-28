package pl.paulkapela.colorchat.component.topic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.paulkapela.colorchat.component.topic.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
