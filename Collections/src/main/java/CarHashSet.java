public class CarHashSet implements CarSet {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTORY = 0.75;
    private Entry[] array = new Entry[INITIAL_CAPACITY];
    private int size = 0;

    @Override
    public boolean add(Car car) {
        if (size >= (array.length * LOAD_FACTORY)) {
            increaseArray();
        }
        boolean added =  add(car, array);
        if (added) {
            size++;
        }
        return added;

    }

    public boolean add(Car car, Entry[] dst) {
        int position = getElementPosition(car, dst.length);
        if (dst[position] == null) {
            dst[position] = new Entry(car, null);
            return true;
        } else {
            Entry existedEntry = dst[position];
            while (true) {
                if (existedEntry.value.equals(car)) {
                    return false;
                } else if (existedEntry.next == null) {
                    existedEntry.next = new Entry(car, null);
                    return true;
                } else {
                    existedEntry = existedEntry.next;
                }
            }
        }
    }

    @Override
    public boolean remove(Car car) {
        int position = getElementPosition(car, array.length);
        if (array[position] == null) {
            return false;
        }
        Entry secondLast = array[position];
        Entry last = secondLast.next;

        if (secondLast.value.equals(car)) {
            array[position] = last;
            size--;
            return true;
        }

        while (last != null) {
            if (last.value.equals(car)) {
                secondLast.next = last.next;
                size--;
                return true;
            } else {
                secondLast = last;
                last = last.next;
            }
        }
        return false;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Entry[INITIAL_CAPACITY];
        this.size = 0;

    }

    private void increaseArray() {
        Entry[] newArray = new Entry[array.length * 2];
        for (Entry entry: array ) {
            Entry existedElement = entry;
            while (existedElement != null) {
                add(existedElement.value, newArray);
                existedElement = existedElement.next;
            }
        }

        array = newArray;
    }


    private int getElementPosition(Car car, int arrayLength) {
        return Math.abs(car.hashCode() % arrayLength);
    }


    private static class Entry {
        private Car value;
        private Entry next;

        public Entry(Car value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }
}
