package nowapps.nxton;

import java.util.HashMap;

public class FindWord {

	public static void main(String a[]) {

		String s1 = "Hello Neo! Welcome to the world of Matrix! Neo! are you awake?";
		int count = 0;
		String maxRepeated = null;
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		String []s1Arr = s1.split(" ");

		for(String tmp : s1Arr) {
			print(tmp);
			if(map.containsKey(tmp)) {

				map.put(tmp, map.get(tmp) + 1);
				int k = map.get(tmp);
				if(k > count) {
					count = k;
					maxRepeated = tmp;
				}
			} else {
				map.put(tmp, 1);
				count=1;
			}
	}

	System.out.println("max repeated word: " + maxRepeated + " , " + count + " times");
	}

	static void print(Object o) {
		System.out.println(o);
	}
}

