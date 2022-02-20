package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2999_박정현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String str = br.readLine();
		int N = str.length();
		int R = 0;
		for (int i = 1; i <= Math.sqrt(N); i++) {
			if (N % i == 0)
				R = Math.max(R, i);
		}
		int C = N / R;
		int temp = R;
		R = C;
		C = temp;
		char[][] arr = new char[R][C];
		int idx = 0;
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					arr[r][c] = str.charAt(idx);
					idx++;
				}
			}
		
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				sb.append(arr[j][i]);
			}
		}
		System.out.println(sb);
	}
}
