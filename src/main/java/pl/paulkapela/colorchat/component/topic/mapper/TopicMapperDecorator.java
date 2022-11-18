package pl.paulkapela.colorchat.component.topic.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import pl.paulkapela.colorchat.component.topic.dto.NewTopic;
import pl.paulkapela.colorchat.component.topic.model.Topic;

import java.time.ZonedDateTime;

public abstract class TopicMapperDecorator implements TopicMapper {

    @Autowired
    @Qualifier("delegate")
    private TopicMapper delegate;

    @Override
    public Topic mapToNewTopic(NewTopic newTopic) {
        if (newTopic == null)
            return null;

        Topic topic = new Topic();

        topic.setType(newTopic.type());
        topic.setUsers(newTopic.users());
        topic.setCreatedAt(ZonedDateTime.now());

        return topic;
    }
}
