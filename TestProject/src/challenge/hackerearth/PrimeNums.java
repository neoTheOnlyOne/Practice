package challenge.hackerearth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimeNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); int
		 * N = Integer.parseInt(br.readLine().trim());
		 * 
		 * String[] strSplit = br.readLine().trim().split(" "); int[] arrInput = new
		 * int[N];
		 * 
		 * for(int i = 0; i < strSplit.length; i++) { arrInput[i] =
		 * Integer.parseInt(strSplit[i]); }
		 */

		/*
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); int
		 * N = Integer.parseInt(br.readLine().trim());
		 * 
		 * String[] strSplit = br.readLine().trim().split(" "); int[] arrInput = new
		 * int[N];
		 * 
		 * for (int i = 0; i < strSplit.length; i++) { arrInput[i] =
		 * Integer.parseInt(strSplit[i]); }
		 */

		int arrInput[] = { 1, 4, 3, 2, 6 };
		List<Integer> primeList = new ArrayList<Integer>();
		List<Integer> nonPrimeList = new ArrayList<Integer>();

		for (int i = 0; i < arrInput.length; i++) {
			if (isPrime(arrInput[i]))
				primeList.add(arrInput[i]);
			else
				nonPrimeList.add(arrInput[i]);
		}
		Collections.sort(primeList);
		Collections.sort(nonPrimeList, Collections.reverseOrder());

		List<Integer> listFinal = new ArrayList<Integer>(primeList.size() + nonPrimeList.size());
		listFinal.addAll(primeList);
		listFinal.addAll(nonPrimeList);
		
		ArrayList<String> al = new ArrayList<String>();
//		al.trimToSize();
		listFinal.forEach(n -> System.out.print(n + " "));

		/*
		 * System.out.println(primeList); System.out.println(nonPrimeList);
		 * System.out.println(listFinal);
		 */
		// listFinal.forEach(System.out::print);

	}

	static boolean isPrime(int n) {
		/*
		 * if (n == 1) return false; for (int i = 2; i < n; i++) { if (n % i == 0)
		 * return false; } return true;
		 */
		// Corner cases
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;

		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i <= n; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}

	public static void complicated(int[] A) {

		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
		}*/

		for (int i = 0; i < A.length; i++) {
			int nextGreat = 0;
			int nextSmall = -1;
			search: for (int j = i + 1; j < A.length; j++) {
				if (A[i] < A[j]) {
					nextGreat = A[j];
					for (int k = j + 1; k < A.length; k++) {
						if (A[j] > A[k]) {
							nextSmall = A[k];
							break search;
						}
					}
				}
			}
			System.out.print(nextSmall + " ");
		}
	}

}
