package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day20SW5432쇠막대기복습 { // 5432 쇠막대 자르기
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			char[] c = br.readLine().toCharArray();

			int ans = 0;
			int stack = 0;
			boolean flag = false;

			for (int n = 0; n < c.length; n++) {
				if (c[n] == '(') {
					stack++;
					flag = true;
				} else if (flag == true && c[n] == ')') {
					stack--;
					ans += stack;
					flag = false;
				} else if (flag == false && c[n] == ')') {
					stack--;
					ans++;
					flag = false;
				}
			}
			sb.append("#").append(tc + 1).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}