package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}
	}

	static long solution() throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < arr.length - 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long revenue = 0;
		int maxIdx = 0;
		while (maxIdx != arr.length - 2) {
			int max = -1;
			int initIdx = maxIdx + 1;
			for (int i = initIdx; i <= arr.length - 2; i++) {
				if (max <= arr[i]) {
					maxIdx = i;
					max = arr[i];
				}
			}

			for (int i = initIdx; i < maxIdx; i++) {
				revenue += (max - arr[i]);
			}
		}

		return revenue;
	}

}
