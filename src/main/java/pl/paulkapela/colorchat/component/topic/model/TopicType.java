package pl.paulkapela.colorchat.component.topic.model;

public enum TopicType {
    DIRECT('d'),
    GROUP('g');

    private final Character symbol;
    TopicType(Character symbol) {
        this.symbol = symbol;
    }

    public Character getSymbol() {
        return symbol;
    }
}
