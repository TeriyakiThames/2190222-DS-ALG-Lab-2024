import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBSTNode {

	@Test
	void testEmpty() {
		int[] preorder = {};

		BSTNode root = BSTNode.preorder2BST(preorder);

		assertEquals(null, root);
	}

	@Test
	void testSimple() {
		int[] preorder = { 2, 1, 3 };

		BSTNode root = BSTNode.preorder2BST(preorder);

		assertEquals(2, root.data);
		assertEquals(1, root.left.data);
		assertEquals(3, root.right.data);

		assertEquals(root, root.left.parent);
		assertEquals(root, root.right.parent);
	}

	@Test
	void testNormal() {
		int[] preorder = { 8, 5, 1, 7, 10, 12 };

		BSTNode root = BSTNode.preorder2BST(preorder);

		assertEquals(8, root.data);
		assertEquals(5, root.left.data);
		assertEquals(1, root.left.left.data);
		assertEquals(7, root.left.right.data);
		assertEquals(10, root.right.data);
		assertEquals(12, root.right.right.data);
		assertEquals(null, root.right.left);

		assertEquals(root, root.left.parent);
		assertEquals(root, root.right.parent);
		assertEquals(root, root.left.left.parent.parent);
		assertEquals(root, root.right.right.parent.parent);
	}

	@Test
	void testOneWay() {
		int[] preorder = { 1, 2, 3, 6, 5, 4 };

		BSTNode root = BSTNode.preorder2BST(preorder);

		assertEquals(1, root.data);
		assertEquals(2, root.right.data);
		assertEquals(3, root.right.right.data);
		assertEquals(6, root.right.right.right.data);
		assertEquals(5, root.right.right.right.left.data);
		assertEquals(4, root.right.right.right.left.left.data);

		assertEquals(null, root.left);
		assertEquals(null, root.right.left);
		assertEquals(null, root.right.right.left);
		assertEquals(null, root.right.right.right.right);
		assertEquals(null, root.right.right.right.left.right);
		assertEquals(null, root.right.right.right.left.left.right);
		assertEquals(null, root.right.right.right.left.left.left);

		assertEquals(root, root.right.right.right.left.left.parent.parent.parent.parent.parent);
	}
}
