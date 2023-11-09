package disciplina_atal.data_structures.tests;

import disciplina_atal.data_structures.linkedlist.MjxConjuntoInteiros;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;

public class MjxConjuntoInteirosTest {

    @Test
    public void testIsEmpty() {
        MjxConjuntoInteiros conjunto = new MjxConjuntoInteiros();
        Assert.assertTrue(conjunto.isEmpty());

        conjunto.add(1);
        Assert.assertFalse(conjunto.isEmpty());
    }

    @Test
    public void testGetHeadAndTail() {
        MjxConjuntoInteiros conjunto = new MjxConjuntoInteiros();
        Assert.assertNull(conjunto.getHead());
        Assert.assertNull(conjunto.getTail());

        conjunto.add(1);
        Assert.assertNotNull(conjunto.getHead());
        Assert.assertNotNull(conjunto.getTail());
    }

    @Test
    public void testAddAndPrintAll() {
        MjxConjuntoInteiros conjunto = new MjxConjuntoInteiros();

        conjunto.add(1);
        conjunto.add(2);
        conjunto.add(3);

        Assert.assertEquals("1\n2\n3\n", getPrintedOutput(conjunto::printAll));
    }

    @Test
    public void testRemove() {
        MjxConjuntoInteiros conjunto = new MjxConjuntoInteiros();

        conjunto.add(1);
        conjunto.add(2);
        conjunto.add(3);

        conjunto.remove(2);

        Assert.assertEquals("1\n3\n", getPrintedOutput(conjunto::printAll));

        conjunto.remove(4);

        Assert.assertEquals("1\n3\n", getPrintedOutput(conjunto::printAll));
    }

    @Test
    public void testUnion() {
        MjxConjuntoInteiros conjunto1 = new MjxConjuntoInteiros();
        conjunto1.add(1);
        conjunto1.add(2);

        MjxConjuntoInteiros conjunto2 = new MjxConjuntoInteiros();
        conjunto2.add(2);
        conjunto2.add(3);

        MjxConjuntoInteiros union = conjunto1.union(conjunto2);

        Assert.assertEquals("1\n2\n3\n", getPrintedOutput(union::printAll));
    }

    @Test
    public void testIntersection() {
        MjxConjuntoInteiros conjunto1 = new MjxConjuntoInteiros();
        conjunto1.add(1);
        conjunto1.add(2);

        MjxConjuntoInteiros conjunto2 = new MjxConjuntoInteiros();
        conjunto2.add(2);
        conjunto2.add(3);

        MjxConjuntoInteiros intersection = conjunto1.intersection(conjunto2);

        Assert.assertEquals("2\n", getPrintedOutput(intersection::printAll));
    }

    @Test
    public void testDifference() {
        MjxConjuntoInteiros conjunto1 = new MjxConjuntoInteiros();
        conjunto1.add(1);
        conjunto1.add(2);

        MjxConjuntoInteiros conjunto2 = new MjxConjuntoInteiros();
        conjunto2.add(2);
        conjunto2.add(3);

        MjxConjuntoInteiros difference = conjunto1.difference(conjunto2);

        Assert.assertEquals("1\n", getPrintedOutput(difference::printAll));
    }

    @Test
    public void testPertinence() {
        MjxConjuntoInteiros conjunto1 = new MjxConjuntoInteiros();
        conjunto1.add(1);
        conjunto1.add(2);

        MjxConjuntoInteiros conjunto2 = new MjxConjuntoInteiros();
        conjunto2.add(1);
        conjunto2.add(2);
        conjunto2.add(3);

        Assert.assertTrue(conjunto1.pertinence(conjunto2));

        conjunto1.add(4);

        Assert.assertFalse(conjunto1.pertinence(conjunto2));
    }

    private String getPrintedOutput(Runnable action) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        action.run();

        System.setOut(System.out);

        return outContent.toString();
    }
}



