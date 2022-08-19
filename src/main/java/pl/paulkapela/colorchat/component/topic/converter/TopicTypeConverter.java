package pl.paulkapela.colorchat.component.topic.converter;

import pl.paulkapela.colorchat.component.topic.model.TopicType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class TopicTypeConverter implements AttributeConverter<TopicType, Character> {

    @Override
    public Character convertToDatabaseColumn(TopicType topicType) {
        if (topicType == null)
            return null;

        return topicType.getSymbol();
    }

    @Override
    public TopicType convertToEntityAttribute(Character symbol) {
        if (symbol == null)
            return null;

        return Stream.of(TopicType.values())
                .filter(t -> t.getSymbol().equals(symbol))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
