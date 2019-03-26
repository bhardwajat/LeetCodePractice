import java.util.HashSet;
import java.util.Set;

class LinkedListNode {
	int data;
	LinkedListNode next;

	LinkedListNode(int data) {
		this.data = data;
		next = null;
	}
}

public class LinkedList {

	static LinkedListNode head;

	public void push(int new_data) {
		LinkedListNode new_node = new LinkedListNode(new_data);

		new_node.next = head;

		head = new_node;
	}

	public int getCount(LinkedListNode head) {
		LinkedListNode temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	public static void findMiddle(LinkedListNode head) {
		LinkedListNode temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		temp = head;
		int pos = count / 2 + 1;
		int i = 1;
		while (i != pos) {
			temp = temp.next;
			i++;
		}
		System.out.println(temp.data);
	}
	
	
	public static int numComponents(LinkedListNode head) {
		int[] G = new int[] {0, 1, 3};
		 Set<Integer> Gset = new HashSet();
	        for (int x: G) Gset.add(x);

	        LinkedListNode cur = head;
	        int ans = 0;

	        while (cur != null) {
	            if (Gset.contains(cur.data) &&
	                    (cur.next == null || !Gset.contains(cur.next.data)))
	                ans++;
	            cur = cur.next;
	        }

	        return ans;
	}
	
	public static Node plusOne(Node head) {
		if(head == null) {
			return null;
		}
		return null;
	}

	

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();
		ll.head = new LinkedListNode(1);
		ll.head.next = new LinkedListNode(2);
		ll.head.next.next = new LinkedListNode(3);
		ll.head.next.next.next = new LinkedListNode(4);
		ll.head.next.next.next.next = new LinkedListNode(5);
		findMiddle(head);

	}

}
