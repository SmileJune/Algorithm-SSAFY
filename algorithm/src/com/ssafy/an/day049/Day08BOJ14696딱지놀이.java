package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day08BOJ14696딱지놀이 { // 14696
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/an/input14696.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < N; tc++) {
			String ans = "D";

			st = new StringTokenizer(br.readLine());
			int[] a = new int[5];
			Integer.parseInt(st.nextToken()); // 횟수 미사용
			while (st.hasMoreTokens())
				a[Integer.parseInt(st.nextToken())]++;

			st = new StringTokenizer(br.readLine());
			int[] b = new int[5];
			Integer.parseInt(st.nextToken()); // 횟수 미사용
			while (st.hasMoreTokens())
				b[Integer.parseInt(st.nextToken())]++;
		
			if (a[4] == b[4]) {
				for (int n = 3; n >= 0; n--) {
					if (a[n] == b[n]) // continue로 최종 조건 맞추기
						continue;
					ans = a[n] > b[n] ? "A" : "B";
					break;
				}
			} else // 우선 조건을 else로 넣기
				ans = a[4] > b[4] ? "A" : "B";
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
