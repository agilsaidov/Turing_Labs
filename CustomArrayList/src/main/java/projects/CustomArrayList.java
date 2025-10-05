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

    public int size(){
        return size;
    }






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
