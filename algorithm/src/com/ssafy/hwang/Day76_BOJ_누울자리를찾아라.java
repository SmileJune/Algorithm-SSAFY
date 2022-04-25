package com.ssafy.hwang;

import java.util.*;

public class Day76_BOJ_누울자리를찾아라 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		char[][] map = new char[N][N];
		int cntR = 0; // 가로 개수
		int cntC = 0; // 세로 개수

		// 입력 받기
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		// 가로, 세로 방향으로 누울 수 있는지 여부
		for (int i = 0; i < N; i++) {
			int check_h = 0, check_v = 0;
			for (int j = 0; j < N; j++) {
				// 가로 체크
				if (map[i][j] == '.')
					check_h++;
				if (map[i][j] == 'X' || (j == N - 1)) {
					if (check_h >= 2)
						cntR++;
					check_h = 0;
				}

				// 세로 체크
				if (map[j][i] == '.')
					check_v++;
				if (map[j][i] == 'X' || (j == N - 1)) {
					if (check_v >= 2)
						cntC++;
					check_v = 0;
				}
			}
		}

		System.out.println(cntR + " " + cntC);
	}
}
