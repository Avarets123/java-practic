import java.util.Arrays;

public class CarArrayList implements CarList {
    private Car[] array = new Car[10];
    private int size = 0;

    @Override
    public Car get(int index) {

        checkIndex(index);
        return array[index];
    }

    @Override
    public void add(Car car) {
        increaseArray();
        array[size] = car;
        size++;
    }

    @Override
    public void add(Car car, int index) {
        increaseArray();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = car;
        size++;
    }

    @Override
    public boolean remove(Car car) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(car)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        System.arraycopy(array, index + 1, array, index, index - 1 - size);
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Car[10];
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseArray() {
        if (array.length <= size) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }
}
