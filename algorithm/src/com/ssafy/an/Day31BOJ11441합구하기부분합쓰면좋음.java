package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day31BOJ11441합구하기부분합쓰면좋음 { // 11441 합 구하기
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];
		int tmp = 0;
		int idx = 0;
		while (st.hasMoreTokens()) {
			tmp += Integer.parseInt(st.nextToken());
			arr[++idx] = tmp;
		}
		int M = Integer.parseInt(br.readLine());
		for (int n = 0; n < M; n++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			sb.append(arr[j] - arr[i - 1]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
