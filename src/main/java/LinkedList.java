import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    public Node<T> head;

    public Node<T> getHead() {
        return this.head;
    }

    public void add(T content) {
        if (this.head == null) {
            this.head = new Node<>(content);
        } else {
            Node<T> currentNode = this.head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = new Node<>(content);
        }
    }

    public int getSize() {
        if (this.head == null) {
            return 0;
        }
        int numberOfElements = 0;
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            numberOfElements++;
            currentNode = currentNode.next;
        }
        return numberOfElements;
    }

    public Iterator<T> iterator() {
        return new ListIterator<>(this);
    }

    public static class Node<T> {
        public T content;
        public Node<T> next;

        public Node(T content) {
            this.content = content;
        }
    }
}

class ListIterator<T> implements Iterator<T> {
    LinkedList.Node<T> current;

    // initialize pointer to head of the list for iteration
    public ListIterator(LinkedList<T> list)
    {
        current = list.getHead();
    }

    // returns false if next element does not exist
    public boolean hasNext()
    {
        return current.next != null;
    }

    // return current data and update pointer
    public T next()
    {
        T data = current.content;
        current = current.next;
        return data;
    }

    // implement if needed
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}
