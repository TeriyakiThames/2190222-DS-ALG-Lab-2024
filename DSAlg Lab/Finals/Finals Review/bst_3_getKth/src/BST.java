
public class BST {
	BSTNode root;
	int size;

	public BST(BSTNode root, int size) {
		this.root = root;
		this.size = size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void makeEmpty() {
		root = null;
		size = 0;
	}

	public Iterator findMin() {
		BSTNode temp = root;
		if (temp == null)
			return null;
		while (temp.left != null) {
			temp = temp.left;
		}
		Iterator itr = new TreeIterator(temp);
		return itr;
	}

	public Iterator findMax() {
		BSTNode temp = root;
		if (temp == null)
			return null;
		while (temp.right != null) {
			temp = temp.right;
		}
		Iterator itr = new TreeIterator(temp);
		return itr;
	}

	public Iterator find(int v) {
		BSTNode temp = root;
		if (v == temp.data)
			return new TreeIterator(temp);

		while (temp != null && temp.data != v) {
			if (v < temp.data) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		if (temp == null) // not found
			return null;
		return new TreeIterator(temp);
	}

	public Iterator insert(int v) {
		BSTNode parent = null;
		BSTNode temp = root;

		// This first part is almost the same as find,
		// but it has an extra pointer called parent.
		while (temp != null && temp.data != v) {
			if (v < temp.data) {
				parent = temp;
				temp = temp.left;

			} else {
				parent = temp;
				temp = temp.right;

			}
		}

		if (temp == null) {
			BSTNode n = new BSTNode(v, null, null, parent);
			if (parent == null) {
				root = n;
			} else if (v < parent.data) {
				parent.left = n;
			} else {
				parent.right = n;
			}
			size++;
			return new TreeIterator(n);
		} else {
			// we do nothing since
			// we don't want to add duplicated data.
			return null;
		}

	}

	public void remove(int v) {
		BSTNode parent = null;
		BSTNode n = root;

		TreeIterator i = (TreeIterator) find(v);
		if (i == null) { // not found, we can not remove it
			return;
		}

		n = i.currentNode;
		parent = n.parent;

		// otherwise, we remove the value.
		size--;
		if (n.left == null && n.right == null) {// both subtrees are empty
			if (parent == null) {
				root = null;
			} else if (parent.left == n) {
				parent.left = null;
				n.parent = null;
			} else {
				parent.right = null;
				n.parent = null;
			}
		} else if (n.left == null && n.right != null) {// only right child
			if (parent == null) {
				root = n.right;
				root.parent = null;
				n.right = null;
			} else if (parent.right == n) {
				BSTNode q = n.right;
				q.parent = parent;
				parent.right = q;
				n.parent = null;
				n.right = null;
			} else {// parent.left == n
				BSTNode q = n.right;
				q.parent = parent;
				parent.left = q;
				n.parent = null;
				n.right = null;
			}
		} else if (n.right == null && n.left != null) {
			if (parent == null) {
				root = n.left;
				root.parent = null;
				n.left = null;
			} else if (parent.right == n) {
				BSTNode q = n.left;
				q.parent = parent;
				parent.right = q;
				n.parent = null;
				n.left = null;
			} else {
				BSTNode q = n.left;
				q.parent = parent;
				parent.left = q;
				n.parent = null;
				n.left = null;
			}

		} else {// n has two subtrees
			BSTNode q = n.right;
			TreeIterator itr = findMin(q);
			BSTNode minInSubtree = itr.currentNode;

			n.data = minInSubtree.data;

			BSTNode parentOfMin = minInSubtree.parent;
			if (parentOfMin.left == minInSubtree) {
				parentOfMin.left = minInSubtree.right;

			} else { // parentOfMin.right == minInSubtree
				parentOfMin.right = minInSubtree.right;

			}

			if (minInSubtree.right != null) {
				minInSubtree.right.parent = parentOfMin;
				minInSubtree.right = null;
			}
			minInSubtree.parent = null;

		}
	}

	private TreeIterator findMin(BSTNode n) {
		BSTNode temp = n;
		while (temp.left != null) {
			temp = temp.left;
		}
		TreeIterator itr = new TreeIterator(temp);
		return itr;
	}

	public boolean contains(int value) {
		return find(value) != null;
	}

	public int[] treeToArray() {
		if (root == null)
			return null;

		int[] a = new int[size];
		int i = 0;
		TreeIterator itr = findMin(root);
		a[i++] = itr.currentNode.data;

		while (itr.hasNext()) {
			try {
				a[i] = itr.next();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}

		return a;

	}

	public void makeBalancedTree() {
		int[] a = new int[size];
		a = treeToArray();

		if (a == null)
			return;

		makeEmpty();
		makeBalancedTree(0, a.length - 1, a);

	}

	public void makeBalancedTree(int[] dataArray) {
		if (dataArray == null)
			return;

		makeEmpty();
		makeBalancedTree(0, dataArray.length - 1, dataArray);
	}

	private void makeBalancedTree(int l, int r, int[] a) {
		if (l > r)
			return;
		int mid = (l + r) / 2;
		insert(a[mid]);
		makeBalancedTree(l, mid - 1, a);
		makeBalancedTree(mid + 1, r, a);

	}

	public void assignTreeSize() {
		assignNodeTreeSize(root);
	}

	private int assignNodeTreeSize(BSTNode node) {
		if (node == null)
			return 0;
		int leftTreeSize = assignNodeTreeSize(node.left);
		int rightTreeSize = assignNodeTreeSize(node.right);
		int currentTreeSize = leftTreeSize + rightTreeSize + 1;
		// assign to current node
		node.TreeSize = currentTreeSize;
		return currentTreeSize;
	}

	// TODO: Implement this method
	public Iterator getKth(int k) {
		return getKth(k, root);
	}

	// Same method with a different signature to recursively go through the BST
	private Iterator getKth(int k, BSTNode n) {
		// Base Case
		if (n == null) {
			return null;
		}

		// Case 1: We find K
		if (n.data == k) {
			TreeIterator itr = new TreeIterator(n);
			return itr;
		}
		// Case 2: K is less than data
		else if (k < n.data) {
			return getKth(k, n.left);
		}
		// Case 3: K is more than data
		else {
			return getKth(k, n.right);
		}
	}

}
