package nowapps.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortDemo {

	public static void main(String args[]) {
		int arr[] = {17, -2, 14, 1, 13, 2, 9, 3, 8, 4, 7, 5, 6, 18 };
		findMinMax(arr);
	}
	
	//find min max with minimum comparisons in unsorted array
	static void findMinMax(int arr[]) {
		int n = arr.length;
		int max=arr[0];
		int min=arr[0];
		int i=0;
		int count=0;
		for(i=0; i<n; i++) {
			if (arr[i] > max) {
				max = arr[i];
				count++;
			}
			if(arr[i] < min){
				min = arr[i];
			}
		}
		System.out.println("count: " + count);
		System.out.println("array length: " + n);
		System.out.println("i: " + i);
		System.out.println("Max: " + max + ", Min:" + min);
	}
	
	void demo(String args[]) {
		List<String> list = Arrays.asList(args);
		Collections.sort(list);
		System.out.println(list);
	}
}
