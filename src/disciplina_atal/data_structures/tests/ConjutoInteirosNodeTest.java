package disciplina_atal.data_structures.tests;

import disciplina_atal.data_structures.linkedlist.ConjutoInteirosNode;

import org.junit.Test;
import org.junit.Assert;

public class ConjutoInteirosNodeTest {

	@Test
    public void testContainsWhenValuePresent() {
        ConjutoInteirosNode node = new ConjutoInteirosNode(1);

        Assert.assertTrue(node.contains(1));
    }

    @Test
    public void testContainsWhenValueNotPresent() {
        ConjutoInteirosNode node = new ConjutoInteirosNode(1);

        Assert.assertFalse(node.contains(2));
    }

    @Test
    public void testContainsWhenNextNodeWithValue() {
        ConjutoInteirosNode node1 = new ConjutoInteirosNode(1);
        ConjutoInteirosNode node2 = new ConjutoInteirosNode(2);
        node1.setNext(node2);

        Assert.assertTrue(node1.contains(2));
    }

    @Test
    public void testContainsWhenNextNodeWithoutValue() {
        ConjutoInteirosNode node1 = new ConjutoInteirosNode(1);
        ConjutoInteirosNode node2 = new ConjutoInteirosNode(2);
        node1.setNext(node2);

        Assert.assertFalse(node1.contains(3));
    }
}



