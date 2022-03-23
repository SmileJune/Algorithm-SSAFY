package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1289_원재의메모리복구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			char[] c = br.readLine().toCharArray();
			int N = c.length;
			int[] bit = new int[c.length];
			for (int i = 0; i < c.length; ++i) {
				bit[i] = c[i] - '0';
			}
			int ans = 0;
			for (int i = 0; i < N; ++i) {
				if (bit[i] == 1) {
					ans++;
					while (i < N) {
						if (bit[i] != 1) {
							ans++;
							break;
						}
						i++;
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}