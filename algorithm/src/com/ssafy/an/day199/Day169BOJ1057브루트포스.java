package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day169BOJ1057브루트포스 {
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());

		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int ans = 0;

		while (A != B) {
			A = A / 2 + A % 2;
			B = B / 2 + B % 2;
			ans++;
		}
		System.out.println(ans);
	}
}
