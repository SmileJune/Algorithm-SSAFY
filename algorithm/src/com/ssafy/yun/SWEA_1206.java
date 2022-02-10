package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1206 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int tc = 1; tc <= 10; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}
	}

	public static int solution() throws NumberFormatException, IOException {
		int len = Integer.parseInt(br.readLine());
		int[] arr = new int[len];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;
		for (int i = 2; i <= arr.length - 3; i++) {
			int max = -1;
			max = Math.max(max, arr[i - 2]);
			max = Math.max(max, arr[i - 1]);
			max = Math.max(max, arr[i + 1]);
			max = Math.max(max, arr[i + 2]);
			int temp = arr[i] - max;

			if (temp > 0) {
				ans += temp;
			}
		}

		return ans;

	}

}
