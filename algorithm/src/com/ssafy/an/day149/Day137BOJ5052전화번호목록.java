package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day137BOJ5052전화번호목록 {
	static int N;
	static String[] phn;
	static boolean ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			phn = new String[N];
			ans = true;
			for (int i = 0; i < N; i++)
				phn[i] = br.readLine();

			Arrays.sort(phn);

			for (int i = 1; i < N; i++)
				if (phn[i].startsWith(phn[i - 1])) {
					ans = false;
					break;
				}

			sb.append(ans ? "YES" : "NO").append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
