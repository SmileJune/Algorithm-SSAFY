package com.ssafy.ehoi;

import java.util.Scanner;

public class Day26_BOJ_S3_2630 {
	static int[][] map;
	static int white = 0;
	static int blue = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 배열의 길이
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		} // 종이 정보 입력 완료

		paper(0, 0, N);

		System.out.println(white);
		System.out.println(blue);

		sc.close();
	}

	// 내가 던질 메서드가 할 역할은
	// 이 페이퍼 안에 있는
	// 1. 숫자가 전부 같은 0이면 white를 ++ 전부 1이면 blue를 ++ 할거야
	// 아니면 4등분해서 그 종이를 각각 다시 재귀로 던질거야
	static int[] dr = { 0, 0, 1, 1 };
	static int[] dc = { 0, 1, 0, 1 };

	public static void paper(int r, int c, int size) {
		if (isSame(r, c, size)) {
			if (map[r][c] == 0) {
				white++;
			} else
				blue++;
			return;
		}
		// 만약 페이퍼 안에 숫자가 같지 않다면
		size /= 2;
		for (int d = 0; d < 4; d++) {
			paper(r + dr[d] * size, c + dc[d] * size, size);
		}

	}

	// 이 페이퍼 안에 있는 숫자가 같은지 판단할 메서드
	public static boolean isSame(int r, int c, int size) {
		int color = map[r][c]; // 시작 인덱스를 하나 받아와

		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (map[i][j] != color) {
					return false;
				}
			}
		}

		return true;
	}

}
