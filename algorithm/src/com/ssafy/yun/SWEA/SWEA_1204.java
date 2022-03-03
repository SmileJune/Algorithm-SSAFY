package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1204 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}
	}

	public static int solution() throws IOException {
		int arr[] = new int[101];
		br.readLine();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 1000; i++) {
			arr[Integer.parseInt(st.nextToken())]++;
		}

		int max = -1;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] == max) {
				return i;
			}
		}
		
		return -1;

	}

}
