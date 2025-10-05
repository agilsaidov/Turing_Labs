package projects;

import java.util.Objects;

public class CustomArrayList<T> {
    private int size;
    private T[] array;


    @SuppressWarnings("unchecked")
    public CustomArrayList() {
        this.size = 0;
        this.array = (T[]) new Object[20];
    }


    //---------------ADD METHODS---------------
    public void add(T element) {
        sizeChecker();
        array[size++] = element;
    }


    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        indexShift(index);
        array[index] = element;
        size++;
    }


    public void addFirst(T element) {
        indexShift(0);
        array[0] = element;
        size++;
    }
    //---------------------------------------------


    //---------------GET METHODS---------------
    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    public T getFirst() {
        return array[0];
    }

    public T getLast() {
        return array[size - 1];
    }
    //---------------------------------------------


    //---------------REMOVE METHODS---------------
    public void remove(int index) {
        checkIndex(index);
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
            if(Objects.equals(array[i],element)) {
                remove(i);
                i--;
            }
        }
    }
    //--------------------------------------------



    //---------------INDEXOF METHODS---------------
    public int indexOf(T element) {
        for(int i = 0; i < size; i++) {
            if(Objects.equals(array[i],element)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T element) {
        for(int i = size - 1; i >= 0; i--) {
            if(Objects.equals(array[i],element)) {
                return i;
            }
        }
        return -1;
    }

    //--------------------------------------------


    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
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


    //--------HELPER METHODS---------
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

    private void checkIndex(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
    }


}
