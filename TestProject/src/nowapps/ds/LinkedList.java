package nowapps.ds;

public class LinkedList {

	private Node head;
	private class Node {
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	public void add(int value) {
		Node newNode = new Node(value);	//initializes value
		newNode.next = head;	//newNode points to previous node
		head = newNode;			// newNode becomes head
	}
	
	public void addLast(int value) {
		Node currentNode = head;
		while(currentNode.next != null) {
			currentNode = currentNode.next;
		}
		Node newNode = new Node(value);
		newNode.next = null;
		currentNode.next = newNode;
	}
	
	public void insertNth(int position, Node head, int value) {
		if(head == null) {
			Node node = new Node(value);
			node.next = null;
			head = node;
		}
	}
	
	
	public void printList() {
		Node node = head;
		while(node != null) {
			doPrint(node.data);
			node = node.next;
		}
	}
	
	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		list.add(10);
		list.add(20);
		list.add(15);
		list.add(7);
		list.add(30);
		list.add(25);
		list.addLast(101);
		doPrint("Printing Linked List items..");
		list.printList();
	}
	
	public static void doPrint(Object o) {
		System.out.println(o);
	}
}
