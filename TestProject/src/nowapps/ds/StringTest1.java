package nowapps.ds;

import java.util.Stack;

public class StringTest1 {

	public static void main(String args[]) {
		String s1 = "{}[]([])";
		String s2 = "[{()}";
		doPrintln(isBalanced(s1));
	}

	static boolean isBalanced(String str) {
		Stack<Character> stack = new Stack<Character>();
		//boolean balanced = false;
		int n = str.length();
		if(str == null || n == 0 || (n % 2) != 0)
			return false;

		for(int i=0; i<str.length(); i++) {
			if(stack.isEmpty()) {
				stack.push(str.charAt(i));
			} else { 
				switch(str.charAt(i)) {
					case '}' : if('{' == (stack.peek())) {
						stack.pop();
					}
					break;
					case ']' : if('['  == (stack.peek())) {
						stack.pop();
					}
					break;
					case ')' : if('(' == (stack.peek())) {
						stack.pop();
					}
					break;
				}
			}
			
		}
		return stack.isEmpty();
	}

	static <T> void doPrintln(T t){
		System.out.println(t);
	}
	static <T> void doPrint(T t){
		System.out.print(t);
	}
}

