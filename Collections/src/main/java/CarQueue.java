import java.util.Collection;

public interface CarQueue extends CarCollections {

    boolean add(Car value);

    Car peek();

    Car poll();
}
