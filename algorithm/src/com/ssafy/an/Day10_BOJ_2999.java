package com.ssafy.an;

import java.util.Scanner;

public class Day10_BOJ_2999 { // 2999 비밀 이메일
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String str = sc.nextLine();
		int N = str.length();
		int R = 0;
		int C = 0;
		for (int n = N; n > 0; n--) {
			if (N % n != 0)
				continue;
			int c = n;
			int r = N / c;
			if (r > c)
				break;
			C = c;
			R = r;
		}
		if (R == 0 && C == 0) {
			R = 1;
			C = 1;
		} // 둘다 0일때.. 고려해야합니다..
		char[][] arr = new char[C][R];
		int s = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				arr[i][j] = str.charAt(s++);
			}
		}
		for (int j = 0; j < R; j++) {
			for (int i = 0; i < C; i++) {
				sb.append(arr[i][j] + "");
			}
		}

		System.out.println(sb);

		sc.close();
	}
}
