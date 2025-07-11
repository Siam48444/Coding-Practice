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


    // Define the head and tail pointers
    private Node head = null;
    private Node tail = null;


    // Adds a node at the beginning
    public void addFirst(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } 
        else {
            newNode.next = head;
            head = newNode;
        }
    }


    // Adds a node at the end
    public void addLast(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }


    // Prints the linked list
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
            ll.addLast(i + 1);
        }

        ll.printList();
    }
}