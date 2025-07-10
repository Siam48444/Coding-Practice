public class MyLinkedList {
    // Node class
    class Node {
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


    // Method to add a node at the beginning
    public void addFirst(String data) {
        Node newNode = new Node(data);

        if (!this.head) {
            this.head = this.tail = newNode;
        } 
        else {
            newNode.next = this.head;
            this.head = newNode;
        }
    }




    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
    }
}