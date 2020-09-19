package day7;
@FunctionalInterface
public interface MessageBuilder {
    // 定义一个拼接消息的方法，返回被拼接的消息
    public abstract String builderMessage();
}
