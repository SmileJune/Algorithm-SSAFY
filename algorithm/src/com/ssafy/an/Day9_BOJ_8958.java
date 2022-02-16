package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day9_BOJ_8958 { // 8958 OX문제
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			char[] sArr = str.toCharArray();
			int cnt = 0;
			int ans = 0;
			for (char c : sArr) {
				if (c == 'O') {
					ans += ++cnt;
				} else if (c == 'X') {
					cnt = 0;
				}
			}

			sb.append(ans).append("\n");
		}

		System.out.println(sb);
		br.close();
	}
}
