package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1592_박정현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		arr[0] = 1;
		int idx = 0;
		int cnt = 0;
		while (arr[idx] != M) {
			if (arr[idx] % 2 == 0) {
				for (int i = 0; i < L; i++) {
					idx -= 1;
					if (idx == -1) idx = N-1;
				}
			} else {
				for (int i = 0; i < L; i++) {
					idx += 1;
					if (idx == N) idx = 0;
				}
			}
			arr[idx]++;
			cnt++;
		}
		System.out.println(cnt);
	}
}
