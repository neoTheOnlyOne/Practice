package nowapps.nxton;

import java.util.Arrays;

public class Test1 {

	static String reverseString(String s) {
		StringBuilder sb = new StringBuilder();
		int i = s.length() - 1;
		for (int j = 0; i >= 0; i--, j++) {
			sb.append(s.charAt(i));
			// doPrint(j + " -> " + sb);
		}
		return sb.toString();
	}

	static boolean isPanlindrome(String s) {
		for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	static String replaceChar(String s, char c) {
		return s.replaceAll("i", "j");
	}
	
	static void convertToByteArray() {
		String str = "www.journaldev.com";
        //convert String to byte array
        byte[] byteArr = str.getBytes();
        System.out.println("String to byte array : "+ Arrays.toString(byteArr));
        //convert byte array to String
        String str1 = new String(byteArr);
        System.out.println("byte array to String : "+str1);
        //let's see if str and str1 are equals or not
        System.out.println("str == str1? " + (str == str1));
        System.out.println("str.equals(str1)? " + (str.equals(str1)));
	}
	
	void t1() { 
		// 
	}

	public static void main(String a[]) {
		String s1 = "Hi Neo!";
		doPrint(reverseString(s1));
		String s = "noon";
		doPrint("checking string '" + s + "' for palindrome");
		doPrint(isPanlindrome(s));
		doPrint(replaceChar(s1, 'i'));
		convertToByteArray();
	}

	static void doPrint(Object o) {
		System.out.println(o);
	}
}
