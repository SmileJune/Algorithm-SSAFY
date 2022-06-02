package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day26BOJ11659구간합누적합 { // 11659 구간 합 구하기 누적합 안쓰면 시간초과 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];
		for (int n = 1; n <= N; n++) {
			arr[n] = arr[n - 1] + Integer.parseInt(st.nextToken());
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			sb.append(arr[n2] - arr[n1 - 1]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
