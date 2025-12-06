public class MyArrayList<T> {

    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        data = (T[]) new Object[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    public T set(int index, T value) {
        checkIndex(index);
        T old = data[index];
        data[index] = value;
        return old;
    }

    public void add(T value) {
        ensureCapacity();
        data[size++] = value;
    }

    public void add(int index, T value) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index);

        ensureCapacity();

        // shift right
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        size++;
    }

    public T remove(int index) {
        checkIndex(index);
        T removed = data[index];

        // shift left
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;

        return removed;
    }

    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value))
                return true;
        }
        return false;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            @SuppressWarnings("unchecked")
            T[] newData = (T[]) new Object[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }

            data = newData;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index);
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
