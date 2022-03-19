package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		for (int i = 0; i < (1 << N); i++) {
			int sum = 0;
			boolean flag = false;
			for (int j = 0; j < N; j++) {
				if((i & (1<<j)) > 0) {
					sum+=arr[j];
					flag = true;
				}
			}
			if(sum == S && flag) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}