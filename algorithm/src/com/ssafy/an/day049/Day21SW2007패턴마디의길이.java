package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day21SW2007패턴마디의길이 { // 2007 패턴 마디의 길이
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			int ed = 1;
			while (true) {
				String a = str.substring(0, ed);
				String b = str.substring(ed, 2 * ed);
				if (a.equals(b))
					break;
				ed++;
			} // 
			sb.append("#").append(tc).append(" ").append(ed).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
