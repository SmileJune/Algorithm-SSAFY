package com.ssafy.namja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1524_박성현 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			long sMax = 0;
			long bMax = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				sMax = Math.max(sMax, Long.parseLong(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				bMax = Math.max(bMax, Long.parseLong(st.nextToken()));
			}
			
			if (sMax >= bMax)
				System.out.println("S");
			else
				System.out.println("B");
		}
	}
}