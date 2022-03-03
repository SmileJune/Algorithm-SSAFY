package com.ssafy.yun.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_2999 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		int N = str.length();
		int R = 0;
		int C = 0;
		for (int i = (int) Math.sqrt(N); i >= 1; i--) {
			if (N % i == 0) {
				R = i;
				C = N / i;
				break;
			}
		}
		char[][] map = new char[R][C];

		int idx = 0;
		for (int j = 0; j < C; j++) {
			for (int i = 0; i < R; i++) {
				map[i][j] = str.charAt(idx++);
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				sb.append(map[i][j]);
			}
		}

		System.out.println(sb.toString());

	}

}
