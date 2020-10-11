import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LinkedListTest {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

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

    @Test
    public void find3rdElementFromTail() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(25);
        list.add(30);

        int result = list.findNthElementFromTail(3);

        Assert.assertEquals(20, result);
    }

    @Test
    public void findNthElementFromTailWhenIndexIsTooBig() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(25);
        list.add(30);

        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Invalid index for given list.");
        int result = list.findNthElementFromTail(6);

        Assert.assertEquals(20, result);
    }

    @Test
    public void createCyclicList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(10);
        list.add(30, true);

        LinkedList.CustomIterator<Integer> iterator = list.iterator();
        iterator.next();
        iterator.next();
        LinkedList.Node<Integer> node = iterator.getCurrentNode();

        Assert.assertEquals(list.head, node.next);
        Assert.assertEquals(list.head.content, node.next.content);
    }

    @Test
    public void isListCyclic() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(10);
        list.add(12);
        list.add(14);
        list.add(17);
        list.add(30, true);

        Assert.assertTrue(list.isCyclic());
    }
}
