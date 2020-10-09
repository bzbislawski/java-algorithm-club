import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void createLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();

        Assert.assertNull(list.head);
    }

    @Test
    public void zeroElements() {
        LinkedList<Integer> list = new LinkedList<>();

        Assert.assertEquals(0, list.getSize());
    }

    @Test
    public void addElementToTheList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(5);
        list.add(8);

        Assert.assertEquals(3, list.getSize());
    }
//

//    @Test
//    public void addElementToTheList() {
//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(5);
//        list.add(8);
//
//        Assert.assertEquals(3, list.getSize());
//    }
}
