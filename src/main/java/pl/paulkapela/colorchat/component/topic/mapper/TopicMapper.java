package pl.paulkapela.colorchat.component.topic.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.paulkapela.colorchat.component.topic.dto.NewTopic;
import pl.paulkapela.colorchat.component.topic.model.Topic;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
@DecoratedWith(TopicMapperDecorator.class)
public interface TopicMapper {

    Topic mapToNewTopic(NewTopic newTopic);
}
