package com.ssafy.yun.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1966 {

	public static int[] arr;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d ", tc);
			printSortedArr();
			System.out.println();
		}

	}

	public static void printSortedArr() throws IOException {
		int len = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[len];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {

			System.out.printf("%d ", arr[i]);
		}

	}

}
