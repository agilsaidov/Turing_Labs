package projects;

public class CustomLinkedList <T>{
     private Node<T> head;
     private int size;
     private Node<T> current;

    public CustomLinkedList() {
        head = null;
        size = 0;
        current = null;
    }


    //Method to add value to the end of List
    public void add(T val) {
        Node<T> newNode = new Node<>(val);

        if(size == 0){
            head = newNode;
            current = newNode;
            size++;

        }else {
            current.next = newNode;
            current = newNode;
            size++;
        }
    }


    //Method to add value to the head
    public void addFirst(T val) {
        Node<T> newNode = new Node<>(val);
        newNode.next = head;
        head = newNode;
        size++;
    }


    //Method to get value
    public T get(T val){
        if(size == 0) return null;
        Node<T> temp = head;

        while(temp != null){
            if(val.equals(temp.value)) return temp.value;
            temp = temp.next;
        }

        return null;
    }


    //Method to get first value
    public T getFirst(){
        if(size == 0) return null;
        return head.value;
    }


    //Method to get last value
    public T getLast(){
        if(size == 0) return null;
        return current.value;
    }


    //Method to remove a node
    public void remove(T val){
        if(size == 0) return;

        Node<T> temp = head;
        Node<T> previous = null;

        if(head.value.equals(val)){
            head = head.next;
            if(size == 1){
                current = null;
            }
            size--;
            return;
        }

        while(temp != null){
            if(val.equals(temp.value)){
                previous.next = temp.next;

                if(temp.equals(current)) current = previous;
                size--;
                return;
            }
            previous = temp;
            temp = temp.next;

        }
    }

    public void removeFirst(){
        if(size == 0) return;
        if(size == 1){
            current = null;
            head = null;
            size--;
            return;
        }
        head = head.next;
        size--;
    }

    public void removeLast(){
        if(size == 0) return;
        if(size == 1){
            current = null;
            head = null;
            size--;
            return;
        }
        Node<T> prev = head;

        while(prev.next != current){
            prev = prev.next;
        }
        prev.next = null;
        current = prev;
        size--;
    }


    //Method to print all values
    public void printList(){
        Node<T> temp = head;
        System.out.print("[ ");
        while(temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.print("]");
    }
}
