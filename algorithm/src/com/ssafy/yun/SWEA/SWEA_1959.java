package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1959 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}
	}

	public static int solution() throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr1 = new int[n];
		int[] arr2 = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		int[] temp;
		if (n < m) {
			temp = arr1;
			arr1 = arr2;
			arr2 = temp;
		}

		int distance = arr1.length - arr2.length;

		int sum = 0;
		int ans = 0;
		for (int i = 0; i <= distance; i++) {
			for (int j = 0; j < arr2.length; j++) {
				sum += arr1[i+j] * arr2[j];
			}
			ans = Math.max(ans, sum);
			sum = 0;
		}

		return ans;
	}

}
