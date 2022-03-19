package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609_최대공약수와최소공배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int NM = (N < M ? N : M);
		int ans1 = 0, ans2 = 0;
		for (int i = NM; i >= 1; --i) {
			if (N % i == 0 && M % i == 0) {
				ans1 = i;
				break;
			}
		}
		for (int i = NM; i <= N * M; ++i) {
			if (i % N == 0 && i % M == 0) {
				ans2 = i;
				break;
			}
		}
		System.out.println(ans1);
		System.out.println(ans2);
	}
}
