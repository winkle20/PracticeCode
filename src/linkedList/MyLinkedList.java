package linkedList;

import java.util.HashSet;
import java.util.Set;

import collections.Node;

public class MyLinkedList {

	Node head;
	int count;

	/** Initialize your data structure here. */
	public MyLinkedList() {
		head = new Node(-1);
		count = 0;
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		if (index < 0 || index >= count) {
			return -1;
		}
		int c = 0;
		Node element = head;
		while (c != index) {
			element = element.next;
			c++;

		}
		return element.data;

	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		Node first = head;
		Node element = new Node(val);
		head = element;
		head.next = first;
		count++;

	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		addAtIndex(count, val);

	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {
		Node nextElement = this.head;
		Node preElement = null;
		int c = 0;
		while (c != index) {
			preElement = nextElement;
			nextElement = nextElement.next;
			c++;
		}
		Node element = new Node(val);
		element.next = nextElement;
		if (preElement != null) {
			preElement.next = element;
		} else {
			head = element;
		}
		count++;
	}

	public boolean hasCycle(Node head) {
		Node slowPointer = head;
		Node fastPointer = head;
		boolean cycle = false;
		while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if (slowPointer == fastPointer) {
				cycle = true;
				break;
			}
		}
		return cycle;
	}

	public Node DetectCycleNode(Node head) {
		if (head == null || head.next == null || head.next.next == null)
			return null;

		Set<Node> s = new HashSet<Node>();
		while (head != null && head.next != null) {
			if (s.contains(head))
				return head;
			s.add(head);
			head = head.next;
		}
		return null;
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if (index < count) {

			Node element = this.head;
			Node preElement = null;
			int c = 0;
			while (c != index) {
				preElement = element;
				element = element.next;
				c++;
			}
			Node nextElement = element.next;
			if (nextElement != null && preElement != null) {
				preElement.next = nextElement;
			} else if (preElement == null) {
				head = nextElement;
			}
			count--;
		}

	}

	public void createCycle(int index) {
		Node nextElement = this.head;
		Node toBeLinked = null;
		int c = 0;
		while (c < count - 1) {
			if (c == index)
				toBeLinked = nextElement;
			nextElement = nextElement.next;
			c++;
		}
		if (toBeLinked != null && nextElement != null) {
			nextElement.next = toBeLinked;
		}
	}

	public Node detectCycle(Node head) {
		if (head == null || head.next == null)
			return null;
		Node tortoise = head;
		Node hare = head;

		do {
			// It is sufficient to check only hare because
			// it will always be ahead of tortoise in an acyclic list.
			if (hare == null || hare.next == null)
				return null;
			tortoise = tortoise.next;
			hare = hare.next.next;
		} while (tortoise != hare);

		tortoise = head;
		while (tortoise != hare) {
			tortoise = tortoise.next;
			hare = hare.next;
		}
		return hare;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyLinkedList myLinkedList = new MyLinkedList();
//		myLinkedList.addAtHead(6);
//		myLinkedList.addAtHead(5);
//		myLinkedList.addAtHead(4);
//		myLinkedList.addAtHead(3);
//		myLinkedList.addAtHead(2);
//		myLinkedList.addAtHead(1);
//		myLinkedList.addAtTail(7);
		myLinkedList.addAtHead(1);
		myLinkedList.addAtIndex(1, 2);
		myLinkedList.addAtIndex(2, 3);
		myLinkedList.addAtIndex(3, 4);
		myLinkedList.addAtIndex(5, 5);
		myLinkedList.addAtIndex(6, 6);
		myLinkedList.addAtIndex(7, 7);
		myLinkedList.createCycle(0);
		System.out.println(myLinkedList.detectCycle(myLinkedList.head));
//		myLinkedList.addAtHead(1);
//		myLinkedList.addAtTail(3);
//		myLinkedList.addAtIndex(1, 2); // linked list becomes 1->2->3
//		myLinkedList.get(1); // return 2
//		myLinkedList.deleteAtIndex(0); // now the linked list is 1->3
//		myLinkedList.get(0); // return 3

	}

}
