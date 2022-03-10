package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_N과M_1 {
	public static int[] arr;
	public static boolean[] bo;
	public static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
 
		arr = new int[M];
		bo = new boolean[N];
		cal(N, M, 0);
		System.out.println(sb);
 
	}
 
	public static void cal(int N, int M, int cnt) {
		if (cnt == M) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
 
		for (int i = 0; i < N; i++) {
			if (!bo[i]) {
				bo[i] = true;
				arr[cnt] = i + 1;
				cal(N, M, cnt + 1);
				bo[i] = false;
			}
		}
	}
 
}