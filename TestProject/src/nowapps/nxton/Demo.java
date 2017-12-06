package nowapps.nxton;

import java.util.HashMap;

public class Demo {

	public static void main(String[] args) {

		HashMap<String, Integer> myMap = new HashMap<String, Integer>();

		// Consider this is one line of a file being read.

		String str = "One two three four Five One Five three Five three Five Five three three three three";

//		str.hashCode();

		String splitStr[] = str.split(" ");

		int maxCount = 0;
		String maxRepeatedWord = null;

		for (int i = 0; i < splitStr.length; i++) {
//		for(String s1 : splitStr)

			System.out.println(splitStr[i] + " ");

			if (myMap.containsKey(splitStr[i])) {

				Integer j = myMap.get(splitStr[i]) + 1;

				if (j > maxCount) {
					maxCount = j;
					maxRepeatedWord = splitStr[i];
				}

				myMap.put(splitStr[i], j);

			}

			else {
				myMap.put(splitStr[i], 1);
			}
		}

		System.out.println("Most repeated word is: " + maxRepeatedWord + ". Repeated " + maxCount + " times.");
	}
}

