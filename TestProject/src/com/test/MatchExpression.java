package com.test;

public class MatchExpression {

	int capacity = 10;
	String[] arrStack = new String[capacity];
	int top = 0;

	public boolean checkMatchingString(String expr) {
		//String[] arrExp = String.split(" ");
		for(int i=0; i < expr.length(); i++) {
			String c = Character.toString(expr.charAt(i));
			switch(c) {
				case "{":
					push(c);break;
				case "[":
					push(c);break;
				case "(":
					push(c);break;
				case "}":
					if(arrStack[top-1].equals("{"))
						pop();break;
				case ")":
					if(arrStack[top-1].equals("("))
						pop();break;
				case "]":
					if(arrStack[top-1].equals("["))
						pop();break;
			}
		}
		return isEmpty();
	}

	void push(String str) {
		if(top > capacity-1) {
			System.out.println("Stack overflow");
			return;
		}
		arrStack[top++] = str;
	}

	String pop() {
		String tmp = "";
		 if(top > 0) {
			tmp = arrStack[--top];
			arrStack[top] = null;
		} else if(top == 0) {
			arrStack[top] = null;
		} else {
			System.out.println("Stack underflow");
		}
		return tmp;
	}
	
	boolean isEmpty() {
		if(arrStack[0] == null || arrStack[0].equals(""))
			return true;
					
		return false;
	}

	void printStack() {
		for(String data : arrStack){
			if(data == null || data.equals(""))
				return;
			doPrintln(data);
		}
	}

	static public <T> void doPrintln(T t) {
		System.out.println(t);
	}

	public static void main(String[] args){
		MatchExpression obj = new MatchExpression();
		
		
		if(obj.checkMatchingString("({(})"))
			doPrintln("Brackets do match");
		else
			doPrintln("Brackets not matching");
		
		
		/*obj.push("Neo");
		obj.push("Trinity");
		obj.push("Anderson");
		obj.push("Joseph");
		obj.push("Neo");
		obj.push("Trinity");
		obj.push("Anderson");
		obj.push("Joseph");
		obj.push("Neo");
		obj.push("Trinity");
		obj.push("Anderson");
		obj.push("Joseph");

		obj.printStack();

		String tmp = obj.pop();
		doPrintln("Object popped: " + tmp);
		tmp = obj.pop();
		doPrintln("Object popped: " + tmp);
		*/
	}
}
