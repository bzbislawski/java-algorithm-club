import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void createLinkedList() {
        LinkedList<String> list = new LinkedList<>();

        Assert.assertNull(list.getHead());
    }

    @Test
    public void addElementToTheList() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Hello");

        Assert.assertEquals(1, list.getSize());
    }

    @Test
    public void addTwoElementsToTheList() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Hello");
        list.add("World");

        Assert.assertEquals(2, list.getSize());
    }
}
