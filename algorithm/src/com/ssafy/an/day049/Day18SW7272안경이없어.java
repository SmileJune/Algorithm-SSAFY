package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day18SW7272안경이없어 {// 7272 안경이 없어
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/an/input7272.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			char[] c1 = st.nextToken().toCharArray();
			char[] c2 = st.nextToken().toCharArray();
			if (c1.length != c2.length) {
				sb.append("#").append(tc).append(" ").append("DIFF").append("\n");
				continue;
			} // 길이 다르면 다른 글자
			String ans = "SAME";
			for (int i = 0; i < c1.length; i++) {
				char a = c1[i];
				char b = c2[i];
				if (blind(a) != blind(b)) {
					ans = "DIFF";
					break;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static int blind(char a) {
		if (a == 'B')
			return 2;
		else if ("ADOPQR".contains(a + ""))
			return 1;
		else
			return 0;
	}
}
