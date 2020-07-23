import java.util.*;

public class p5639{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n ;
		Tree t = new Tree();

		while(in.hasNext()) {
			n = in.nextInt();
			t.add(n, t.root);
		}

		t.post(t.root);
	}

}

class Tree {
	Node root;

	Tree() {
		root = null;
	}

	public void add(int value, Node node) {
		if(node == null) {
			Node newnode = new Node(value);
			root = newnode;
		}
		else {
			Node newnode = new Node(value);
			if(value == node.value) {}
			else if(value > node.value) {
				if(node.right == null) 
					node.right = new Node(value);
				else					
					add(value, node.right);
			}
			else {
				if(node.left == null) 
					node.left = new Node(value);
				else					
					add(value, node.left);
			}
		}

	}

	public void post(Node node) {
		if(node.left != null)
			post(node.left);
		if(node.right != null)
			post(node.right);
		System.out.println(node.value);
	}

}

class Node {
	int value;
	Node left;
	Node right;

	Node(int value) {
		this.value = value;
		left = null;
		right = null;
	}
}
