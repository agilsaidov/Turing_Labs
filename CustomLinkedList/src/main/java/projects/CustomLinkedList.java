package projects;

public class CustomLinkedList <T>{
     private Node head;
     private int size;
     private Node current;

    public CustomLinkedList() {
        head = null;
        size = 0;
        current = null;
    }

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
