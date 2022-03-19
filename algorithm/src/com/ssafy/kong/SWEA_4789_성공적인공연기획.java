package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4789_성공적인공연기획 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			String str = br.readLine();
			int n = str.length();
			int[] crap = new int[n + 1];
			for (int i = 1; i <= n; ++i) {
				crap[i] = str.charAt(i - 1) - '0';
			}
			int ans = 0; // 고용해야 할 사람의 수
			int p = 0; // 박수친 사람의 수
			p += crap[1];
			for (int i = 2; i <= n; ++i) {
				if (p < i - 1 && crap[i] > 0) {
					ans += (i - 1) - p;
					p += (i - 1) - p;
//					System.out.println("i: " + i + " crap : " + crap[i - 1]);
//					System.out.println("ans: " + ans);
				}
				p += crap[i];
			}
			System.out.println("#" + t + " " + ans);
		}

	}
}