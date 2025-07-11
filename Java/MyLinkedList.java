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
        while (curr.next != null) {
            curr = curr.next;
            System.out.print(curr.data + " ");
        }
    }





    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();

        ll.addFirst("1");
        ll.addFirst("2");
        ll.addFirst("3");

        ll.printList();
    }
}