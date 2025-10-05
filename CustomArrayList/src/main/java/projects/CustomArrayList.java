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




    private void sizeChecker(){
        if(size == array.length){
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) new Object[array.length + 20];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }


}
