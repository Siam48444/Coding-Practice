public class MyLinkedList<T> {
    // Node class
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }


    // Define the head and tail pointers, and size tracker
    private Node head = null;
    private Node tail = null;
    private int size = 0;


    // Adds a node at the beginning --> O(1)
    public void addFirst(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } 
        else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }


    // Adds a node at the end --> O(1)
    public void addLast(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    // Adds a node at specified index --> O(n)
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
        
        if (index == 0) {
            addFirst(data);
        }
        else if (index == size) {
            addLast(data);
        }
        else {
            Node newNode = new Node(data);
            Node curr = head;
            
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            
            newNode.next = curr.next;
            curr.next = newNode;
            size++;
        }
    }


    // Deletes the first node --> O(1)
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty!");
        }
        else {
            head = head.next;
            size--;
        }
    }


    // Deletes the last node --> O(n)
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty!");
        }
        else if (head == tail) {
            head = tail = null;
            size--;
        }
        else {
            Node curr = head;
            while (curr.next != tail) {
                curr = curr.next;
            }
            curr.next = null;
            tail = curr;
            size--;
        }
    }    


    // Deletes a node at specified index --> O(n)
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
        
        if (index == 0) {
            deleteFirst();
        }
        else if (index == size - 1) {
            deleteLast();
        }
        else {
            Node curr = head;
            
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            
            curr.next = curr.next.next;
            size--;
        }
    }


    // Returns the first element --> O(1)
    public T getFirst() {
        if (head == null) {
            System.out.println("List is empty!");
            return null;
        }
        else {
            return head.data;
        }
    }

    
    // Returns the last element --> O(1)
    public T getLast() {
        if (head == null) {
            System.out.println("List is empty!");
            return null;
        }
        else {
            return tail.data;
        }
    }


    // Returns the size of the linked list --> O(1)
    public int size() {
        return size;
    }


    // Prints the linked list --> O(n)
    public void printList() {
        if (head == null) {
            System.out.println("List is empty!");
        }
        else {
            Node curr = head;
            String seperator = ", ";

            while (curr != null) {
                System.out.print(curr.data);
                if (curr.next != null) {
                    // only add comma if there's a next node
                    System.out.print(seperator);  
                }
                curr = curr.next;
            }
            System.out.println();
        }
    }





    public static void main(String[] args) {
        MyLinkedList<Integer> ll = new MyLinkedList<>();

        for (int i = 0; i < 10; i++) {
            ll.addLast(i);
        }

        ll.printList();
    }
}