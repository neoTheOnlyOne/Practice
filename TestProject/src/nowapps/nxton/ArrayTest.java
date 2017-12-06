package nowapps.nxton;

import java.util.HashMap;

public class ArrayTest {

	public static void main(String args[]) {
		//int arr[] = {2, 7, 9, 7, 2, 4, 7, 10};
		int arr[] = {2, 7, 2, 7, 2, 4, 7, 2};

		for(int i : arr){
			System.out.print(i + ", ");
		}
		System.out.println("");
		
		int newLen = findNewArrayLen(arr, 7);
		System.out.println("original: " + arr.length);
		System.out.println("new: " + newLen);
		for(int i : arr){
			System.out.print(i + ", ");
		}
	}

	static int findNewArrayLen(int arr[], int value)  {
		
		int swapCounter = 0;
		int n = arr.length;
		int tmp = -1;

		for(int i=0; i<n; i++) {
			
			doPrintln("swapCounter: " + swapCounter);

			if(i >= n-swapCounter) {
				//break;
			}
			if(arr[i] == value) {
				for(int j=n-1; j>i; j--) {
					if(arr[j] != value) {
						tmp = arr[j];
						arr[i] = tmp;
						arr[j] = value;
						swapCounter = n-j;
						doPrintln("swapped indexes: " + i + " and " + (n-swapCounter));
						break;
					}
				}
				
				for(int j : arr){
					doPrint(j + ", ");
				}
			}
		}
		
		return n-swapCounter;
	}

	static void doPrint(Object o) {
		System.out.print(o);
	}
	static void doPrintln(Object o) {
		System.out.println(o);
	}
	
	void testMethod() {
		StringBuilder s;
		StringBuffer sb;
		HashMap map;
	}
}
