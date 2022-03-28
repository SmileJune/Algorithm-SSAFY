package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day48_BOJ_B3_10250 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());

			if (N % H == 0) {
				System.out.println(H * 100 + (N / H));
			} else {
				System.out.println(((N % H) * 100) + (N / H + 1));
			}

		}
	}
}
