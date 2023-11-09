package disciplina_atal.data_structures.tests;

import disciplina_atal.data_structures.linkedlist.MjxLinkedList;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;

public class MjxLinkedListTest {

    @Test
    public void testAdd() {
        MjxLinkedList list = new MjxLinkedList();

        list.add("Alice", 1);
        list.add("Bob", 2);
        list.add("Charlie", 3);

        Assert.assertEquals("Alice", list.getHead().getName());
        Assert.assertEquals(1, list.getHead().getKey());
        Assert.assertEquals("Charlie", list.getTail().getName());
        Assert.assertEquals(3, list.getTail().getKey());
    }

    @Test
    public void testRemove() {
        MjxLinkedList list = new MjxLinkedList();

        list.add("Alice", 1);
        list.add("Bob", 2);
        list.add("Charlie", 3);

        list.remove("Bob", 2);

        Assert.assertEquals("Alice", list.getHead().getName());
        Assert.assertEquals(1, list.getHead().getKey());
        Assert.assertEquals("Charlie", list.getTail().getName());
        Assert.assertEquals(3, list.getTail().getKey());
    }

    @Test
    public void testGetCopy() {
        MjxLinkedList originalList = new MjxLinkedList();
        originalList.add("Alice", 1);
        originalList.add("Bob", 2);
        originalList.add("Charlie", 3);

        MjxLinkedList copiedList = originalList.getCopy();

        Assert.assertNotSame(originalList, copiedList);
        Assert.assertEquals(originalList.getHead().getName(), copiedList.getHead().getName());
        Assert.assertEquals(originalList.getTail().getName(), copiedList.getTail().getName());
    }

    @Test
    public void testJoinList() {
        MjxLinkedList list1 = new MjxLinkedList();
        list1.add("Alice", 1);
        list1.add("Bob", 2);

        MjxLinkedList list2 = new MjxLinkedList();
        list2.add("Charlie", 3);

        list1.joinList(list2);

        Assert.assertEquals("Alice", list1.getHead().getName());
        Assert.assertEquals(1, list1.getHead().getKey());
        Assert.assertEquals("Charlie", list1.getTail().getName());
        Assert.assertEquals(3, list1.getTail().getKey());
    }

    @Test
    public void testInterleaveList() {
        MjxLinkedList list1 = new MjxLinkedList();
        list1.add("Alice", 1);
        list1.add("Charlie", 2);
        
        MjxLinkedList list2 = new MjxLinkedList();
        list2.add("Bob", 3);
        list2.add("Theo", 4);

        list1.interleaveList(list2);

        Assert.assertEquals("Alice", list1.getHead().getName());
        Assert.assertEquals(1, list1.getHead().getKey());
        Assert.assertEquals("Theo", list1.getTail().getName());
        Assert.assertEquals(4, list1.getTail().getKey());
    }
    
    @Test
    public void testPrintAll() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        MjxLinkedList list = new MjxLinkedList();
        list.add("Alice", 1);
        list.add("Bob", 2);
        list.add("Charlie", 3);

        list.printAll();

        String expectedOutput = "Alice(1)\nBob(2)\nCharlie(3)\n";
        Assert.assertEquals(expectedOutput, outContent.toString());

        System.setOut(System.out);
    }
}


