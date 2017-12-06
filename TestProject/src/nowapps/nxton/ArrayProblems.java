package nowapps.nxton;

import java.util.HashSet;
import java.util.Set;

public class ArrayProblems {

	public static void main(String args[]) {
		int[] arr = { 2, 7, 2, 5, 7, 2, 4, 5, 7, 5, 10, 1 };
		arrangeMatchingElements(arr, 5);
		System.out.println("Matching Elements final o/p");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		
		
		int arr1[] = {10, 5, 3, 4, 3, 5, 6, 10, 1};
		int repeatElem = findFirstRepeatElement(arr1);
		System.out.println("\n\nfirst repeat element: " + repeatElem);
	}

	/** arranges all matching elements for the given value k, at the end of array */
	static void arrangeMatchingElements(int arr[], int k) {
		int n = arr.length;
		int rightIndex = n - 1;
		for (int i = 0; i < n; i++) {
			if (k == arr[i]) {
				for (int j = rightIndex; j > i; j--) {
					if (k != arr[j]) {
						rightIndex = j;
						break;
					}
				}
				arr[i] = arr[rightIndex];
				arr[rightIndex] = k;
				for (int m : arr) {
					System.out.print(m + " ");
				}
				System.out.println("");
			}
		}
	}

	/** Find the first repeating element in an array of integers */
	static int findFirstRepeatElement(int arr[]) {
		Set<Integer> set = new HashSet<Integer>();
		int repeatElement=-1;
		int n = arr.length-1;
		for(int i=n; i>=0; i--) {
			if(!set.add(arr[i])) {
				repeatElement = arr[i];
			}
		}
		return repeatElement;
	}
}
