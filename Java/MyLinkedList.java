public class MyLinkedList {
    // Node class
    private class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }


    // Define the head and tail pointers
    private Node head = null;
    private Node tail = null;


    // Adds a node at the beginning
    public void addFirst(String data) {
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
    public void addLast(String data) {
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





    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();

        ll.addLast("1");
        ll.addLast("2");
        ll.addLast("3");

        ll.printList();
    }
}