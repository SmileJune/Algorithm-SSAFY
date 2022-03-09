package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day31BOJ10986나머지합테케양주의시간초과무조건 { // 10986 나머지 합
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int[] arr = new int[M]; // 나머지 갯수 배열
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cnt = (cnt + Integer.parseInt(st.nextToken())) % M;
			arr[cnt]++;
		}
		long ans = arr[0]; // 시간초과 유도됨...
		for (int i = 0; i < M; i++) {
			ans += (long) arr[i] * (arr[i] - 1) / 2;
		}
		System.out.println(ans);
		br.close();
	}
}
