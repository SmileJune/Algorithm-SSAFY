package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4698_테네스의특별한소수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			boolean[] arr = new boolean[B + 1];
			arr[0] = true;
			arr[1] = true;
			for (int i = 2; i * i <= B; ++i) {
				if (arr[i] == false) {
					for (int j = i * i; j <= B; j += i) {
						arr[j] = true;
					}
				}
			}
			int ans = 0;
			for (int i = A; i <= B; ++i) {
				if (!arr[i]) {
					if ((i + "").contains("" + D))
						ans++;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}