package projects;

public class CustomArrayList<T> {
    private int size;
    @SuppressWarnings("unchecked")
    T[] array = (T[]) new Object[20];


    public CustomArrayList() {
        this.size = 0;
    }


    public void add(T t) {
        sizeChecker();
        array[size++] = t;
    }


    public void add(int index, T t) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        indexShift(index);
        array[index] = t;
        size++;
    }


    public void addFirst(T t) {
        indexShift(0);
        array[0] = t;
        size++;
    }


    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return array[index];
    }

    public T getFirst() {
        return array[0];
    }

    public T getLast() {
        return array[size - 1];
    }


    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        array[index] = null;
        for(int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(size - 1);
    }

    public void removeAll(T element){
        for(int i = 0; i < size; i++) {
            if(array[i].equals(element)) {
                remove(i);
            }
        }
    }


    public int size(){
        return size;
    }


    public int indexOf(T t) {
        for(int i = 0; i < size; i++) {
            if(array[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T t) {
        for(int i = size - 1; i >= 0; i--) {
            if(array[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < size; i++) {
            sb.append(array[i]);
            if(i<size-1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //Helper Methods
    private void sizeChecker(){
        if(size == array.length){
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) new Object[array.length + 20];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }

    private void indexShift(int index) {
        sizeChecker();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
    }


}
