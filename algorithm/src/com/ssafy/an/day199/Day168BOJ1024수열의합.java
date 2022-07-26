package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day168BOJ1024수열의합 {
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		long num = Long.parseLong(st.nextToken());
		int split = Integer.parseInt(st.nextToken());

		long divide;
		long start;
		StringBuilder sb = new StringBuilder();
		while (true) {
			divide = num / split;
			start = split % 2 == 0 ? divide - split / 2 + 1 : divide - split / 2;
			if (split > 100 || start < 0) {
				sb.append("-1\n");
				break;
			} else if ((split % 2 == 0 && (double) num / split - divide == 0.5)
					|| (split % 2 == 1 && (double) num / split - divide == 0)) {
				for (long i = 0; i < split; i++) {
					sb.append(start + i).append(' ');
				}
				break;
			}
			split++;
		}
		System.out.print(sb);
	}
}