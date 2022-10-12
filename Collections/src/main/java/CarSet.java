public interface CarSet extends CarCollections {
    boolean add(Car car);
    boolean remove(Car car);
    int size();
    void clear();
}
