package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978_소수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int cnt = 0, ans = 0;

		for (int i = 1; i <= N; i++) {
			int num2 = Integer.parseInt(st.nextToken());
			cnt = 0;
			for (int j = 1; j <= num2; j++) {
				if (num2 % j == 0)
					cnt++;
			}

			if (cnt == 2)
				ans++;
		}
		System.out.print(ans);
	}
}