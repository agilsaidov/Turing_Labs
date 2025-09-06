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


    //Index based add method
    public void add(int index, T val) {
        if(index < 0 || index > size) {throw new IndexOutOfBoundsException();}

        Node<T> newNode = new Node<>(val);

        if(index == 0){
            addFirst(val);
            return;
        }

        if(index == size){
            add(val);
            return;
        }

        Node<T> temp = head;

        for (int i = 0; i < index-1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;

    }


    //Method to add value to the head
    public void addFirst(T val) {
        Node<T> newNode = new Node<>(val);
        newNode.next = head;
        head = newNode;
        if(size == 0) current = newNode;
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


    //Index based get method
    public T get(int index){
        if(size == 0) throw new IndexOutOfBoundsException();
        return getNodeAt(index).value;
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


    //Method to find index of element
    public int indexOf(T val){
        if(size == 0) return -1;
        Node<T> temp = head;

        for(int i = 0; i < size; i++){
            if(val.equals(temp.value)) return i;
            temp = temp.next;
        }

        return -1;
    }


    //Method to find index of the last occurrence of given element
    public int lastIndexOf(T val){
        if(size == 0) return -1;
        Node<T> temp = head;
        int result = -1;

        for(int i =0 ; i<size; i++){
            if(val.equals(temp.value)){
                result = i;
            }
            temp = temp.next;
        }
        return result;
    }


    //Method to update elements
    public void set(int index, T val) {
        if(size ==0) throw new IndexOutOfBoundsException();
        getNodeAt(index).value = val;
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


    //Index based remove
    public void remove(int index){
        if(size == 0) throw new IndexOutOfBoundsException();

        if(index == 0){
            removeFirst();
            return;
        }

        Node<T> previous = getNodeAt(index-1);
        Node<T> nodeToRemove = previous.next;


        removeNode(previous,nodeToRemove);
    }


    //Method to remove the first node
    public void removeFirst(){
        if(handleEmptyAndSingleRemoval()) return;
        head = head.next;
        size--;
    }


    //Method to remove the last node
    public void removeLast(){
        if(handleEmptyAndSingleRemoval()) return;

        Node<T> prev = head;

        while(prev.next != current){
            prev = prev.next;
        }
        prev.next = null;
        current = prev;
        size--;
    }


    //Method to remove the last occurred node
    public void removeLastOccurrence(T val){
        if(size == 0) return;

        Node<T> temp = head;
        Node<T> previous = null;
        Node<T> actual = null;
        Node<T> previousTemp = null;

        while(temp != null){
            if(val.equals(temp.value)){
                previous = previousTemp;
                actual = temp;
            }
            previousTemp = temp;
            temp = temp.next;

        }
        if(actual != null){
            removeNode(previous,actual);
        }
    }



    //Return size of List
    public int size(){
        return size;
    }


    //Check if List is empty
    public boolean isEmpty(){
        return size == 0;
    }


    //Method to print all values
    public void printList(){
        Node<T> temp = head;
        System.out.print("[");
        while(temp != null){
            if(temp.next != null) {
                System.out.print(temp.value + ", ");

            }else System.out.print(temp.value+"]\n");
            temp = temp.next;
        }
    }



    //Helper method
    private void removeNode(Node<T> pre, Node<T> node){
        if (pre == null) {
            head = node.next;
        } else {
            pre.next = node.next;
        }

        if (node == current) {
            current = pre;
        }

        size--;
    }

    //Helper Method
    private Node<T> getNodeAt(int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    //Helper Method
    private boolean handleEmptyAndSingleRemoval() {
        if(size == 0) return true;

        if(size == 1) {
            head = null;
            current = null;
            size--;
            return true;
        }

        return false;
    }
}
