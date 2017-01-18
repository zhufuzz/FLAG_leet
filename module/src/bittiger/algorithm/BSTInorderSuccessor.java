package bittiger.algorithm;
//http://blog.csdn.net/fightforyourdream/article/details/19860143

public class BSTInorderSuccessor {

	public static void main(String[] args) {
		Node root = null;
		root = insert(root, 20);
		root = insert(root, 8);
		root = insert(root, 22);
		root = insert(root, 4);
		root = insert(root, 12);
		root = insert(root, 10);
		root = insert(root, 14);

		Node temp = root.left.right.right;
		Node succ = inorderSuccessor(root, temp);
		succ = inorderSuccessor2(root, temp);
		if (succ != null) {
			System.out.println(temp.data + "'s successor is " + succ.data);
		} else {
			System.out.println("error");
		}
	}

	// 1）需要parent指针的做法
	// 找inorder successor 分右孩子是否存在的两种情况考虑
	// O(h) h: height of tree
	public static Node inorderSuccessor(Node root, Node node) {
		if (node.right != null) {		// 有右孩子，直接找右子树的最小节点
			return minValue(node.right);
		}

		// 否则利用父指针不断向上找，直到父节点的值大于当前节点的值
		// 或者该节点成为父节点的右孩子
		Node parent = node.parent;
//		while (parent != null && node == parent.right) {
		while (parent != null && node.data > parent.data) {
			node = parent;
			parent = parent.parent;
		}
		return parent;
	}
	
	
	// 2）不需要parent指针的做法
	// 过程其实就是个从root查找node节点的过程，同时保存旧的比node大的root节点，作为succ
	// O(h)
	public static Node inorderSuccessor2(Node root, Node node) {
		if (node.right != null) {		// 有右孩子，直接找右子树的最小节点
			return minValue(node.right);
		}
		
		Node succ = null;
		while(root != null) {
			if(root.data > node.data) {	// 继续找更小的
				succ = root;		// 后继节点必然比node要大，所以只能在这里保存
				root = root.left;
			}
			else if(root.data < node.data){		// 继续找更大的
				root = root.right;
			}
			else{		// root节点和node节点重复，停止
				break;
			}
		}
		return succ;
	}
	
	

	/*
	 * Given a non-empty binary search tree, return the minimum data value found
	 * in that tree. Note that the entire tree does not need to be searched.
	 */
	public static Node minValue(Node node) {
		Node cur = node;

		// 最小节点必定在最左下角
		while (cur.left != null) {
			cur = cur.left;
		}
		return cur;
	}

	/*
	 * Give a binary search tree and a number, inserts a new node with the given
	 * number in the correct place in the tree. Returns the new root pointer
	 * which the caller should then use (the standard trick to avoid using
	 * reference parameters).
	 * 
	 * 返回插入后节点的引用
	 */
	public static Node insert(Node node, int data) {
		if (node == null) {
			return new Node(data);
		} else { 			// node 存在
			Node temp;

			if (data <= node.data) {
				temp = insert(node.left, data);
				node.left = temp;
				temp.parent = node;
			} else {
				temp = insert(node.right, data);
				node.right = temp;
				temp.parent = node;
			}
			return node;
		}
	}

	static class Node {
		int data;
		Node left;
		Node right;
		Node parent;

		public Node(int data) {
			this.data = data;
		}
	}

}
