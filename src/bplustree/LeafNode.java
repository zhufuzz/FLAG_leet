package bplustree;

public class LeafNode extends Node {

	protected LeafNode(int d, Node n, Node p) {
		super(d, n, p);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int minkeys() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	void printNode() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean combinable(Node other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void combine() {
		// TODO Auto-generated method stub

	}

	@Override
	public int redistribute() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertSimple(int val, Node ptr, int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSimple(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public Reference search(int val) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(int val, Node ptr) {
		// TODO Auto-generated method stub

	}

}
