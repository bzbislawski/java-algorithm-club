import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    public Node<T> head;

    @Override
    public CustomIterator<T> iterator() {
        return new CustomIterator<>(this.head);
    }

    public void add(T content) {
        if (this.head == null) {
            this.head = new Node<>(content);
            return;
        }

        CustomIterator<T> iterator = this.iterator();

        while (iterator.hasNext()) {
            iterator.next();
        }

        iterator.node.next = new Node<>(content);
    }

    public int getSize() {
        CustomIterator<T> iterator = this.iterator();
        if (iterator.getCurrentNode() == null) {
            return 0;
        }
        int numberOfElements = 1;
        while (iterator.hasNext()) {
            numberOfElements++;
            iterator.next();
        }
        return numberOfElements;
    }

    public static class Node<T> {
        public Node<T> next;
        public T content;

        public Node(T content) {
            this.content = content;
        }
    }

    private static class CustomIterator<T> implements Iterator<T> {
        public Node<T> node;

        public Node<T> getCurrentNode() {
            return this.node;
        }

        public CustomIterator(Node<T> node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return this.node.next != null;
        }

        @Override
        public T next() {
            this.node = this.node.next;
            return this.node.content;
        }
    }
}
