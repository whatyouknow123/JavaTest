package jingdong;

import java.util.Scanner;

public class SecurityCiteCorrect {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int n = sc.nextInt();
			long arr[] = new long[n];
			// int flag[][] = new int[n][n];

			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextLong();
				// flag[i][(i + 1) % n] = 1;
				// flag[(i + 1) % n][i] = 1;
			}
			int ret = 0;

			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					// ??
					boolean flag = true;
					for (int k = i + 1; k < j; k++) {
						if (arr[k] > arr[i] || arr[k] > arr[j]) {
							flag = false;
							break;
						}
					} // ??
					if (flag) {
						ret++;
						continue;
					}

					flag = true;
					for (int k = j + 1; k < i + n; k++) {
						if (arr[k % n] > arr[i] || arr[k % n] > arr[j]) {
							flag = false;
							break;
						}
					}
					if (flag) {
						ret++;

					}
				}
			}
			System.out.println(ret);
		}
	}
}
