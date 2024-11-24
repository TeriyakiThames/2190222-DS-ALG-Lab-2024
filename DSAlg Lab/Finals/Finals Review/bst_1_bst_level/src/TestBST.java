import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBST {
	BST tree;

	@BeforeEach
	void setup() throws Exception {
		tree = new BST();
	}

	@Test
	void testEmpty() {
		ArrayList<Integer> ans;

		ans = tree.atLevel(0);
		assertEquals(0, ans.size());
		ans = tree.atLevel(1);
		assertEquals(0, ans.size());
		ans = tree.atLevel(2);
		assertEquals(0, ans.size());
		ans = tree.atLevel(3);
		assertEquals(0, ans.size());
		ans = tree.atLevel(5);
		assertEquals(0, ans.size());
		ans = tree.atLevel(10);
		assertEquals(0, ans.size());
		ans = tree.atLevel(25);
		assertEquals(0, ans.size());
		ans = tree.atLevel(50);
		assertEquals(0, ans.size());
		ans = tree.atLevel(100);
		assertEquals(0, ans.size());
	}

	@Test
	void testSimple1() {
		ArrayList<Integer> ans;

		tree.insert(5);

		ans = tree.atLevel(0);
		assertEquals(1, ans.size());
		assertEquals(5, ans.get(0));

		ans = tree.atLevel(1);
		assertEquals(0, ans.size());
		ans = tree.atLevel(2);
		assertEquals(0, ans.size());
		ans = tree.atLevel(3);
		assertEquals(0, ans.size());
		ans = tree.atLevel(5);
		assertEquals(0, ans.size());
		ans = tree.atLevel(10);
		assertEquals(0, ans.size());
		ans = tree.atLevel(25);
		assertEquals(0, ans.size());
		ans = tree.atLevel(50);
		assertEquals(0, ans.size());
		ans = tree.atLevel(100);
		assertEquals(0, ans.size());
	}

	@Test
	void testSimple2() {
		ArrayList<Integer> ans;

		tree.insert(8);
		tree.insert(4);
		tree.insert(9);

		ans = tree.atLevel(0);
		assertEquals(1, ans.size());
		assertEquals(8, ans.get(0));

		ans = tree.atLevel(1);
		assertEquals(2, ans.size());
		assertEquals(9, ans.get(0));
		assertEquals(4, ans.get(1));

		ans = tree.atLevel(2);
		assertEquals(0, ans.size());
		ans = tree.atLevel(3);
		assertEquals(0, ans.size());
		ans = tree.atLevel(5);
		assertEquals(0, ans.size());
		ans = tree.atLevel(10);
		assertEquals(0, ans.size());
		ans = tree.atLevel(25);
		assertEquals(0, ans.size());
		ans = tree.atLevel(50);
		assertEquals(0, ans.size());
		ans = tree.atLevel(100);
		assertEquals(0, ans.size());
	}

	@Test
	void testComplex1() {
		ArrayList<Integer> ans;

		tree.insert(6);
		tree.insert(0);
		tree.insert(-9);
		tree.insert(-5);
		tree.insert(2);
		tree.insert(-11);
		tree.insert(8);
		tree.insert(90);
		tree.insert(80);

		ans = tree.atLevel(0);
		assertEquals(1, ans.size());
		assertEquals(6, ans.get(0));

		ans = tree.atLevel(1);
		assertEquals(2, ans.size());
		assertEquals(8, ans.get(0));
		assertEquals(0, ans.get(1));

		ans = tree.atLevel(2);
		assertEquals(3, ans.size());
		assertEquals(90, ans.get(0));
		assertEquals(2, ans.get(1));
		assertEquals(-9, ans.get(2));

		ans = tree.atLevel(3);
		assertEquals(3, ans.size());
		assertEquals(80, ans.get(0));
		assertEquals(-5, ans.get(1));
		assertEquals(-11, ans.get(2));

		ans = tree.atLevel(5);
		assertEquals(0, ans.size());
		ans = tree.atLevel(10);
		assertEquals(0, ans.size());
		ans = tree.atLevel(25);
		assertEquals(0, ans.size());
		ans = tree.atLevel(50);
		assertEquals(0, ans.size());
		ans = tree.atLevel(100);
		assertEquals(0, ans.size());
	}

	@Test
	void testComplex2() {
		ArrayList<Integer> ans;

		tree.insert(0);

		for (int i = 1; i <= 90; i++) {
			tree.insert(2 * i);
			tree.insert(2 * i - 1);
		}

		for (int i = 1; i <= 60; i++) {
			tree.insert(-i);
		}

		ans = tree.atLevel(0);
		assertEquals(1, ans.size());
		assertEquals(0, ans.get(0));

		ans = tree.atLevel(1);
		assertEquals(2, ans.size());
		assertEquals(2, ans.get(0));
		assertEquals(-1, ans.get(1));

		for (int i = 2; i <= 60; i++) {
			ans = tree.atLevel(i);
			assertEquals(3, ans.size());
			assertEquals(2 * i, ans.get(0));
			assertEquals(2 * i - 3, ans.get(1));
			assertEquals(-i, ans.get(2));
		}

		for (int i = 61; i <= 90; i++) {
			ans = tree.atLevel(i);
			assertEquals(2, ans.size());
			assertEquals(2 * i, ans.get(0));
			assertEquals(2 * i - 3, ans.get(1));
		}

		ans = tree.atLevel(91);
		assertEquals(1, ans.size());
		assertEquals(179, ans.get(0));
	}
}
