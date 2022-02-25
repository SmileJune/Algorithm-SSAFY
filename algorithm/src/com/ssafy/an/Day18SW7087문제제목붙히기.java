package com.ssafy.an;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Day18SW7087문제제목붙히기 { // 7087 문제 제목 붙이기
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/an/input7087.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] cnt = new int[26];// 영문자 카운팅
			for (int n = 0; n < N; n++) {
				cnt[br.readLine().charAt(0) - 'A']++;
			}
			int ans = 0;
			for (int i = 0; i < 26; i++) {
				if (cnt[i] == 0) {
					break;
				}
				ans++;
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
