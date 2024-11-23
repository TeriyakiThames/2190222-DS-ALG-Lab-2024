public class Treap {
	TreapNode root;
	int size;

	public Treap() {
		root = null;
		size = 0;
	}

	public Treap(TreapNode root, int size) {
		this.root = root;
		this.size = size;
	}

	public TreapNode insert(int BSTValue, int heapValue) {
		// Return null if the value already exists
		if (contains(root, BSTValue)) {
			return null;
		}

		// Insert node into tree
		TreapNode newNode = new TreapNode(BSTValue, heapValue);
		root = insert(root, newNode);
		size++;

		return newNode;
	}

	private TreapNode insert(TreapNode currentNode, TreapNode newNode) {
		// Return newNode as the root
		if (currentNode == null) {
			return newNode;
		}

		// Insert to the left if the newNode's value < currentNode's value
		if (newNode.bstValue < currentNode.bstValue) {
			currentNode.left = insert(currentNode.left, newNode);

			// If left child has a smaller heap value, rotate right
			if (currentNode.left != null && currentNode.left.heapValue < currentNode.heapValue) {
				currentNode = rotateRight(currentNode);
			}

		// Insert to the right if the newNode's value > currentNode's value
		} else {
			currentNode.right = insert(currentNode.right, newNode);

			// If right child has a smaller heap value, rotate left
			if (currentNode.right != null && currentNode.right.heapValue < currentNode.heapValue) {
				currentNode = rotateLeft(currentNode);
			}
		}

		return currentNode;
	}

	// Helper method to check if node is in the tree
	private boolean contains(TreapNode n, int v) {
		if (n == null) {
			return false;
		}

		if (n.bstValue == v) {
			return true;
		}

		if (v < n.bstValue) {
			return contains(n.left, v);
		}

		return contains(n.right, v);

	}

	// If the left child has a smaller heap value, rotate right
	private TreapNode rotateRight(TreapNode y) {
		TreapNode x = y.left;
		TreapNode T = x.right;

		x.right = y;
		y.left = T;

		return x;
	}

	// If the right child has a smaller heap value, rotate left
	private TreapNode rotateLeft(TreapNode x) {
		TreapNode y = x.right;
		TreapNode T = y.left;

		y.left = x;
		x.right = T;

		return y;
	}
}
