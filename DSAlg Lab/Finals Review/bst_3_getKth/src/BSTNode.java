
public class BSTNode {
	int data; // value stored in the node.
	BSTNode left; // pointer to lower left BSTNode.
	BSTNode right; // pointer to lower right BSTNode.
	BSTNode parent; // pointer to the BSTNode above.
	int TreeSize;

	public BSTNode(int data) {
		this(data, null, null, null);
	}

	public BSTNode(int data, BSTNode left, BSTNode right, BSTNode parent) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.parent = parent;
		this.TreeSize = 0;
	}

	public static void main(String[] args) {
		BSTNode b = new BSTNode(9);
	}
}
