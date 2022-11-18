package pl.paulkapela.colorchat.component.topic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.paulkapela.colorchat.component.topic.model.Topic;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    Optional<Topic> findById(Long id);

    @Query("select t from Topic t " +
           "inner join t.users u on t member of u.topics " +
           "where t.type = pl.paulkapela.colorchat.component.topic.model.TopicType.DIRECT " +
           "and u.username in (?#{ authentication?.name }, :contraUsername)")
    Optional<Topic> findByContraUsername(String contraUsername);
}
