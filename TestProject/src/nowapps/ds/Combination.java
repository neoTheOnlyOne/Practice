package nowapps.ds;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Combination {

	public static void main(String[] args) {

		Scanner input = null;
		try {
			input = new Scanner(System.in);

			int T = 5;
			T = input.nextInt();
			for (int i = 0; i < T; i++) {
				int N = 5;
				N = input.nextInt();

				if (N <= 2)
					System.out.println(comb(N, 1));
				else
					System.out.println(comb(N, 2) + comb(N, 1));
				input.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			input.close();
		}
		

		// niceQuery();

	}

	public static int comb(int n, int r) {

		int[][] cr = new int[n + 1][r + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(cr[i], -1);
		}

		if (cr[n][r] != -1)
			return cr[n][r];

		if (r == 0 || n == r)
			return 1;

		int ans = (comb(n - 1, r) + comb(n - 1, r - 1)) % (int) 1E9;

		return cr[n][r] = ans;

	}

	static void niceQuery() {
		int n = 0;
		int q = 0;

		Scanner sc1 = new Scanner(System.in);
		String s1 = sc1.nextLine();
		String sArr[] = s1.split("\\s");

		n = Integer.parseInt(sArr[0]);
		q = Integer.parseInt(sArr[1]);

		int arr[] = new int[n];
		int qType = 0;
		int k = 0;
		int y = 0;
		int tmp = 0;
		boolean found = false;

		for (int i = 0; i < q; i++) {
			found = false;
			Scanner scan = new Scanner(System.in);
			String s2 = sc1.nextLine();
			String sArr1[] = s2.split("\\s");
			qType = Integer.parseInt(sArr1[0]);
			tmp = Integer.parseInt(sArr1[1]);
			
			TreeSet<Integer> tSet = new TreeSet<Integer>();
			

			if (qType == 1) {
				k = tmp;
				tSet.add(tmp);
				arr[k - 1] = -1;
			} else if (qType == 2) {
				y = tmp;
				int x = y;
				if (x > n) {
					System.out.println("-1");
					continue;
				}
				int highest = tSet.last();
				
				/*for (int j = x - 1; j < n; j++) {
					if (arr[j] == -1) {
						System.out.println(j + 1);
						found = true;
					}
				}*/
				if (!found) {
					System.out.println("-1");
				}
			}
		}
	}

}
