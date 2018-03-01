import java.util.Scanner;

public class LinkList {
	// SinglyLinkedList
	int data;
	LinkList next;
	static LinkList head;
	static LinkList tail;

	LinkList getNewNode(int data) { // this method only creates a block of
		// memory that contains 2 field i.e data and address field. and passes the
		// address of the block.

		LinkList newNode = new LinkList();
		newNode.data = data;
		return newNode;

	}

	void createList(int data) {

		LinkList newNode = getNewNode(data);

		newNode.next = null;
		head = newNode;
		tail = newNode;

	}

	void addNodeBeg(int data) {
		LinkList newNode = getNewNode(data);

		newNode.next = head;
		head = newNode;

	}

	void addNodeEnd(int data) {
		LinkList newNode = getNewNode(data);

		tail.next = newNode;
		tail = newNode;
		tail.next = null;

	}

	void addNodeMid(int data, int pos) {
		LinkList newNode = getNewNode(data);
		LinkList temp = head;
		for (int i = 1; i < pos - 1; i++) {

			temp = temp.next;
		}

		newNode.next = temp.next;
		temp.next = newNode;

	}

	void delNodeBeg() {
		LinkList temp = head;
		head = temp.next;
		temp = null;
	}

	void delNodeEnd() {
		LinkList temp = tail;
		LinkList prev = null;
		LinkList n = head;
		while (n.next != null) {
			prev = n;
			n = n.next;
		}
		prev.next = null;
		tail = prev;
		temp = null;

	}

	void delNodeMid(int pos) {

		LinkList temp = head;

		for (int i = 1; i < pos - 1; i++) {
			temp = temp.next;
		}

		LinkList temp1 = temp.next;
		temp.next = temp1.next;

		temp1 = null;

	}

	void printList(LinkList ref) {
		System.out.print("The link list is :  |-");
		while (ref != null) {

			System.out.print(ref.data + "-");
			ref = ref.next;
		}
		System.out.print("|");
	}
	
	
	int  addAllItems() {
		
		LinkList ref = head;
		int total = 0;
		
		while (ref != null) {

			total = total + ref.data;
			ref = ref.next;
		}
		return total;
	}
	
	
	/**
	 * this function is used to get the no of items present in the linked list.
	 * 
	 * @return
	 * int - no of item in list
	 */
	
	int getItemCount() {
		LinkList ref = head;
		int count = 0;
		while(ref!=null) {
		count++;
		ref = ref.next;
		}
		return count;
	}

	
	void reverseLinkList(LinkList h) {
		// Reversing a link list using iterative method .

		LinkList prev = null; // to reverse the link and save the intermediate address
		LinkList current = h;// to traverse the linked list
		LinkList next = null;// to store address of the the address part of the node , so that list is not
										// lost

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		head = prev;
		printList(head);
		System.out.println();

	}

	void printLinkListUsingRecursion(LinkList h) {

		if (h == null) {
			System.out.println();
			return;
		}
		System.out.print(+h.data + "-");

		printLinkListUsingRecursion(h.next);
	}

	void reversePrintLinkListUsingRecursion(LinkList h) {

		if (h == null)
			return;

		reversePrintLinkListUsingRecursion(h.next);
		System.out.print(h.data + "-");
	}

	

	
}
