/**
 *
 */
package nowapps.nxton;

/**
 * @author Mahesh
 *
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		generateFibonacciSeries();

	}

	static void generateFibonacciSeries1() {
		int a=0,b = 1,c=0;
		int seriesCount=10;
		System.out.print(a+" ");
		for (int i = 1; c<seriesCount; ++i) {
			System.out.print(c+" ");
			c=a+b;
			a=b;
			b=c;
		}
	}


	static void generateFibonacciSeries() {
		int m = 0;
		int n = 1;
		int k = 0;
		//print(m);
		for(int i=0; k<56; i++) {
			m = n;
			n = k;
			print(k);
			k = m + n;
		}
	}

	static void print(Object o) {
		System.out.println(o);
	}

}
