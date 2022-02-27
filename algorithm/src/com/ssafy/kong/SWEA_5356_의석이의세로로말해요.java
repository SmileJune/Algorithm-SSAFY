package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_5356_의석이의세로로말해요 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			StringBuilder sb = new StringBuilder();
			char[][] word = new char[5][];
			int max = 0;
			for (int i = 0; i < 5; ++i) {
				word[i] = br.readLine().toCharArray();
				max = Math.max(max, word[i].length);
			}
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < max; ++i) {
				for (int j = 0; j < 5; ++j) {
					if (i < word[j].length)
						sb.append(word[j][i]);
				}
			}
			System.out.println(sb);
		}
	}
}
