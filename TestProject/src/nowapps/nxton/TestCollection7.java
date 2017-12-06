package nowapps.nxton;

import java.util.Iterator;
import java.util.LinkedList;

public class TestCollection7 {

	public static void main(String[] args) {
		
		System.out.println("Hi Neo !");
		
	}
	
	static void testLinkedList() {
		LinkedList<String> al = new LinkedList<>();
		al.add("Bodhi");
		al.add("Jhonny");
		al.add("Grommet");
		al.add("Roach");
		
		Iterator<String> itr = al.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}		
	}
	
	static void findFirstChar(String s) {
		char[] c = s.toCharArray();
		for(int i=0; i < c.length; i++) {
			
		}
	}
}

