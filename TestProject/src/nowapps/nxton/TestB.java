package nowapps.nxton;

import java.util.Scanner;

public class TestB extends TestA {

	public static void main(String a[]) {

		Scanner sc = new Scanner(System.in);
//		a[0] = sc.next();
//		a[1] = sc.next();
		
		
		TestA objA = new TestB();
		//objA.doSum(Integer.parseInt(a[0]), Integer.parseInt(a[1]));
		objA.doSum(3, 5);
		objA.doSomething();
	}

	public int doSum(int a, int b) {
		System.out.println("method of class TestB called: " );
		System.out.println(a + b);
		return a + b;
	}

}