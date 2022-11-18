package pl.paulkapela.colorchat.component.topic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.paulkapela.colorchat.component.topic.dto.NewTopic;
import pl.paulkapela.colorchat.component.topic.mapper.TopicMapper;
import pl.paulkapela.colorchat.component.topic.model.Topic;
import pl.paulkapela.colorchat.component.topic.repository.TopicRepository;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;

    public Topic createTopic(NewTopic newTopic) {
        return topicRepository.save(topicMapper.mapToNewTopic(newTopic));
    }
}
