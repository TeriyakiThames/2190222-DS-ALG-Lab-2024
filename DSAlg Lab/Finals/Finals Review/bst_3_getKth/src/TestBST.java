import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.channels.InterruptedByTimeoutException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class TestBST {

	@BeforeEach
	void setUp() throws Exception {

	}

	@Test
	@Timeout(1)
	void testTimeComplexity1() {
		BST t = new BST(null, 0);
		final int LARGE_SIZE = 1000;
		int[] dataArray = new int[LARGE_SIZE];
		for (int i = 0; i < LARGE_SIZE; i++) {
			dataArray[i] = i;
		}
		t.makeBalancedTree(dataArray);
		t.assignTreeSize();
		for (int i = 0; i < LARGE_SIZE; i++) {
			TreeIterator it = (TreeIterator) t.getKth(i);
			assertEquals(i, it.currentNode.data);

		}
	}

	@Test
	@Timeout(1)
	void testTimeComplexity2() {
		BST t = new BST(null, 0);
		final int LARGE_SIZE = 100000;
		int[] dataArray = new int[LARGE_SIZE];
		for (int i = 0; i < LARGE_SIZE; i++) {
			dataArray[i] = i;
		}
		t.makeBalancedTree(dataArray);
		t.assignTreeSize();
		for (int i = 0; i < LARGE_SIZE; i++) {
			TreeIterator it = (TreeIterator) t.getKth(i);
			assertEquals(i, it.currentNode.data);

		}
	}

	@Test
	@Timeout(1)
	void testTimeComplexity3() {
		BST t = new BST(null, 0);
		final int LARGE_SIZE = 200000;
		int[] dataArray = new int[LARGE_SIZE];
		for (int i = 0; i < LARGE_SIZE; i++) {
			dataArray[i] = i;
		}
		t.makeBalancedTree(dataArray);
		t.assignTreeSize();
		for (int i = 0; i < LARGE_SIZE; i++) {
			TreeIterator it = (TreeIterator) t.getKth(i);
			assertEquals(i, it.currentNode.data);

		}
	}

	@Test
	@Timeout(1)
	void testTimeComplexity4() {
		BST t = new BST(null, 0);
		final int LARGE_SIZE = 250000;
		int[] dataArray = new int[LARGE_SIZE];
		for (int i = 0; i < LARGE_SIZE; i++) {
			dataArray[i] = i;
		}
		t.makeBalancedTree(dataArray);
		t.assignTreeSize();
		for (int i = 0; i < LARGE_SIZE; i++) {
			TreeIterator it = (TreeIterator) t.getKth(i);
			assertEquals(i, it.currentNode.data);

		}
	}

	@Test
	@Timeout(1)
	void testTimeComplexity5() {
		BST t = new BST(null, 0);
		final int LARGE_SIZE = 500000;
		int[] dataArray = new int[LARGE_SIZE];
		for (int i = 0; i < LARGE_SIZE; i++) {
			dataArray[i] = i;
		}
		t.makeBalancedTree(dataArray);
		t.assignTreeSize();
		for (int i = 0; i < LARGE_SIZE; i++) {
			TreeIterator it = (TreeIterator) t.getKth(i);
			assertEquals(i, it.currentNode.data);

		}
	}

	@Test
	@Timeout(1)
	void testTimeComplexity6() {
		BST t = new BST(null, 0);
		final int LARGE_SIZE = 1000000;
		int[] dataArray = new int[LARGE_SIZE];
		for (int i = 0; i < LARGE_SIZE; i++) {
			dataArray[i] = i;
		}
		t.makeBalancedTree(dataArray);
		t.assignTreeSize();
		for (int i = 0; i < LARGE_SIZE; i++) {
			TreeIterator it = (TreeIterator) t.getKth(i);
			assertEquals(i, it.currentNode.data);

		}
	}

}
