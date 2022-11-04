public class Box<T, K, V> {

    private T name;
    private K first;
    private V second;

    public Box(T name, K first, V second) {
        this.name = name;
        this.first = first;
        this.second = second;
    }

    public T getName() {
        return name;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}
