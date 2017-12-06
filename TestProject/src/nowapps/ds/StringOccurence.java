package nowapps.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringOccurence {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		checkString();
	}

	static void checkString() {

		Map<String, Integer> stringMap = new HashMap<String, Integer>();
		Scanner scanInput = new Scanner(System.in);
		int a = scanInput.nextInt();
		doPrintln("Enter " + a + " Strings");
		
		for (int i = 0; i < a; i++) {
			String tmp = scanInput.next();
			if (stringMap.containsKey(tmp))
				stringMap.put(tmp, stringMap.get(tmp) + 1);
			else
				stringMap.put(tmp, 1);
		}
		
		scanInput.close();
		for (Map.Entry<String, Integer> entry : stringMap.entrySet()) {
			doPrintln(entry.getKey() + entry.getValue());
		}
	}

	static <T> void doPrintln(T t) {
		System.out.println(t);
	}
}
