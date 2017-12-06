package nowapps.nxton;

public class LinkedList {

	Node head;
	private class Node {
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	public void push(int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
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
		list.push(10);
		list.push(20);
		list.push(15);
		list.push(7);
		list.push(30);
		list.push(25);
		doPrint("Printing Linked List items..");
		list.printList();
	}
	
	public static void doPrint(Object o) {
		System.out.println(o);
	}
}
