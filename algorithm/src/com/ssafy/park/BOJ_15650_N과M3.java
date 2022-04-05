package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650_N과M3 {
	static int[] arr;
	static int[] sel;
	static int N, M;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		sel = new int[M];
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		comb(0,0);
		System.out.println(sb);
	}
	public static void comb(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			sel[cnt] = arr[i];
			comb(cnt + 1, start);
		}
	}
}
