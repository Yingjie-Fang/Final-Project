public class LinkedList<T> {
    // Node class to represent each element in the list
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head; // first node in the list
    private int size;     // number of elements in the list

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        
        // If list is empty, new node becomes head
        if (head == null) {
            head = newNode;
        } else {
            // Otherwise, find the last node and append the new node
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public T get(int index) {
        // If out of bounds, throw exception
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        
        // Traverse to the correct node
        Node<T> current = head;
        for (int i = 0; i < index; i++)
            current = current.next;
        
        return current.data;
    }

    public T remove(int index) {
        // If out of bounds, throw exception
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        T removed;

        if (index == 0) {
            // Removing the head
            removed = head.data;
            head = head.next;
        } else {
            // Find the node *before* the one to remove
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++)
                current = current.next;

            removed = current.next.data;
            current.next = current.next.next;
        }
        size--;
        return removed;
    }

    public int size() {
        return size;
    }

    // Helpful for debugging, same style as ArrayList’s toString()
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null)
                sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
