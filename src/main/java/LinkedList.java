import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    public Node<T> head;

    @Override
    public CustomIterator<T> iterator() {
        return new CustomIterator<>(this.head);
    }

    public void add(T content, boolean pointToHead) {
        if (this.head == null) {
            this.head = new Node<>(content);
            return;
        }

        CustomIterator<T> iterator = this.iterator();

        while (iterator.hasNext()) {
            iterator.next();
        }
        if (pointToHead) {
            iterator.node.next = new Node<>(content, this.head);
        } else {
            iterator.node.next = new Node<>(content);
        }
    }

    public void add(T content) {
        this.add(content, false);
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

    public T findNthElementFromTail(int index) throws Exception {
        if (index > this.getSize() - 1) {
            throw new Exception("Invalid index for given list.");
        }
        CustomIterator<T> fastIterator = this.iterator();
        CustomIterator<T> slowIterator = this.iterator();

        int iterationCount = 0;
        int iterationCountMax = index - 1;
        T slowPointer = null;
        while (fastIterator.hasNext()) {
            fastIterator.next();
            if (iterationCountMax >= iterationCount) {
                slowPointer = slowIterator.next();
            }
            iterationCount++;
        }
        return slowPointer;
    }

    public boolean isCyclic() {
        CustomIterator<T> fastIterator = this.iterator();
        CustomIterator<T> slowIterator = this.iterator();

        while (fastIterator.hasNext()) {
            fastIterator.next();
            fastIterator.next();
            slowIterator.next();
            if (fastIterator.getCurrentNode() == slowIterator.getCurrentNode()) {
                return true;
            }
        }

        return false;
    }

    public static class Node<T> {
        public Node<T> next;
        public T content;

        public Node(T content) {
            this.content = content;
        }

        public Node(T content, Node<T> pointTo) {
            this.content = content;
            this.next = pointTo;
        }
    }

    static class CustomIterator<T> implements Iterator<T> {
        private Node<T> node;

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
