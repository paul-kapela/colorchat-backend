package pl.paulkapela.colorchat.component.topic.model;

public enum TopicType {
    DIRECT("d"),
    GROUP("g");

    private final String symbol;

    TopicType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
