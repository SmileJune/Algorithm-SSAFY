package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day16BOJ10799쇠막대기 { // 10799 쇠막대기
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/input5432.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] c = br.readLine().toCharArray();

		int ans = 0;
		int stack = 0;

		for (int n = 0; n < c.length; n++) {
			if (c[n] == '(') {
				stack++;
				continue;
			}
			stack--;
			ans += c[n - 1] == '(' ? stack : 1;
		}

		System.out.println(ans);
	}
}
