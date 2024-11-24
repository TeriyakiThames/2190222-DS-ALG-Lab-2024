public class BSTNode {
	int data; // value stored in the node.
	BSTNode left; // pointer to lower left BSTNode.
	BSTNode right; // pointer to lower right BSTNode.
	BSTNode parent; // pointer to the BSTNode above.

	public BSTNode(int data) {
		this(data, null, null, null);
	}

	public BSTNode(int data, BSTNode left, BSTNode right, BSTNode parent) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

	public static void main(String[] args) {
		BSTNode b = new BSTNode(9);
	}

	// TODO: Implement this method
	// Create a field to keep track of the index
	static int index = 0;

	public static BSTNode preorder2BST(int[] preorder) {
		index = 0;
		// Integer.MIN_VALUE is the least possible value whereas
		// Integer.MAX_VALUE is the largest possible value.
		// These values are here as a placeholder.
		return buildTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, null);
	}

	// Helper method to recursively build a BST
	private static BSTNode buildTree(int[] preorder, int min, int max, BSTNode parent) {
		// Return if index is out of bounds
		if (index >= preorder.length) {
			return null;
		}

		// Return if value is less than the MIN or more than the MAX values
		int value = preorder[index];
		if (value < min || value > max) {
			return null;
		}
		index++;

		// Create the new node, then assign its parent, left subtree and right subtree
		BSTNode node = new BSTNode(value);
		node.parent = parent;
		node.left = buildTree(preorder, min, value - 1, node);
		node.right = buildTree(preorder, value + 1, max, node);

		return node;
	}
}