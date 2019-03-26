import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class Tree {

	Node root;

	public Tree() {
		root = null;
	}

	public static void levelOrder(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node node = q.poll();
				System.out.print(node.data + " ");
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
			System.out.println();
		}
	}

	public static void printLeaves(Node root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			System.out.println(root.data);
		}
		printLeaves(root.left);
		printLeaves(root.right);

	}

	public static void postOrderItr(Node root) {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty()) {
			Node temp = s1.pop();
			if (temp.left != null) {
				s1.push(temp.left);
			}
			if (temp.right != null) {
				s1.push(temp.right);
			}
			s2.push(temp);
		}
		while (!s2.isEmpty()) {
			System.out.println(s2.pop().data);
		}
	}

	public static Node insertIntoBST(Node root, int val) {
		if (root == null) {
			return new Node(val);
		}
		if (root.data < val) {
			root.right = insertIntoBST(root.right, val);
		} else {
			root.left = insertIntoBST(root.left, val);
		}
		return root;
	}

	public static void preOrderItr(Node root) {
		Stack<Node> s = new Stack<>();
		s.push(root);
		while (!s.isEmpty()) {
			Node node = s.pop();
			System.out.println(node.data);
			if (node.right != null) {
				s.push(node.right);
			}
			if (node.left != null) {
				s.push(node.left);
			}
		}
	}

	public static boolean isUnival(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		int ans = root.data;
		while (!q.isEmpty()) {
			Node node = q.peek();
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
			int num = node.data;
			System.out.println(ans);
			if (ans != num) {
				return false;
			}
			q.poll();
		}
		return true;
	}

	public static int maxDepth(Node root) {
		int leftCount = 0;
		int rightCount = 0;
		if (root == null) {
			return 0;
		}
		leftCount = maxDepth(root.left);
		rightCount = maxDepth(root.right);
		return 1 + Math.max(leftCount, rightCount);
	}

	public static List<Integer> findLargest(Node root) {
		if(root == null) {
			return null;
		}
		Queue<Node> q = new LinkedList<>();
		List<Integer> l = new ArrayList<>();
		q.add(root);
		//l.add(root.data);
		while(!q.isEmpty()) {
			int size = q.size();
			int max = Integer.MIN_VALUE;
			while(size != 0) {
				Node node = q.poll();
				max = Math.max(max, node.data);
				if(node.left != null) {
					q.add(node.left);
					//max = Math.max(max, node.left.data);
				}
				if(node.right != null) {
					q.add(node.right);
					//max = Math.max(max,  node.right.data);
				}
				size--;
			}
				l.add(max);
		}
		return l;
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		Node root = new Node(1);
		tree.root = root;
		tree.root.left = new Node(3);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(5);
		tree.root.left.right = new Node(3);
		tree.root.right.right = new Node(9);
		tree.root.right.left = new Node(8);
		System.out.println(findLargest(root));
	}

}
