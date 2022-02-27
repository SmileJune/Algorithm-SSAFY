package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7272_안경이없어 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; ++t) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			String w1 = st.nextToken();
			String w2 = st.nextToken();
			// CEFGHIJKLMNSTUVWXYZ : 같은문자
			// ADOPQR : 같은문자
			// B : 같은문자
			String[] alpa = { "CEFGHIJKLMNSTUVWXYZ", "ADOPQR", "B" };
			sb.append("#").append(t).append(" ");

			int n1 = w1.length();
			int n2 = w2.length();
			if (n1 != n2) {
				sb.append("DIFF");
				System.out.println(sb);
				continue;
			}
			boolean flag = true;
			for (int i = 0; i < n1; ++i) {
				for (int j = 0; j < alpa.length; ++j) {
					if (alpa[j].contains(String.valueOf(w1.charAt(i)))) {
						if (!alpa[j].contains(String.valueOf(w2.charAt(i)))) {
							flag = false;
						}
					}
				}
			}
			sb.append(flag ? "SAME" : "DIFF");
			System.out.println(sb);
		}
	}
}