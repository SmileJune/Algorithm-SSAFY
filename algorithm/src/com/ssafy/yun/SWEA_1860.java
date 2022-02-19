package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1860 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;

	static int N, M, K;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %s%n", tc, solution());
		}
	}

	static String solution() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		try {
			for (int i = 0; i < arr.length; i++) {
				recur(0, 0, i);
			}
		} catch (RuntimeException e) {
			return "Impossible";
		}

		return "Possible";
	}

	static void recur(int sec, int num, int idx) throws RuntimeException {
		if (sec > arr[idx]) {
			if (num - K < idx + 1) {
				throw new RuntimeException();
			}
			return;
		}

		recur(sec + M, num + K, idx);
	}

}
