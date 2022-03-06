package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day27_S2_1780 {
	static int[][] map;
	static int[] ans = new int[3];

	static int[] dr = { 0, 0, 0, 1, 1, 1, 2, 2, 2 };
	static int[] dc = { 0, 1, 2, 0, 1, 2, 0, 1, 2 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 종이 길이 입력
		map = new int[N][N]; // 종이 크기
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken())+ 1; // 종이 정보 입력 받을 때 하나씩 더해서 입력받기
			}
		}
		
		divide(0, 0, N);

		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		} // 출력

		
	}

	// 2. true면 그 수가 어떤 숫자인지 판단해서 정답 배열의 그 인덱스 값을 ++시키고
	// false면 분할해서 다시 검사하게 하는 재귀 메서드
	public static void divide(int r, int c, int N) {
		if (isSame(r, c, N)) { // 모든 값이 같다면
			ans[map[r][c]]++;
			return;
		}
		// 아니면 다시 분할해야지 -> 9분할
		// 사이즈는 3분의 1

		N /= 3;
		for (int d = 0; d < 9; d++) {
			divide(r + dr[d] * N, c + dc[d] * N, N);
		}

	}

	// 1. 종이에 모든 수가 같은지 판단하는 메서드 (정복)
	public static boolean isSame(int r, int c, int N) {
		int pivot = map[r][c]; // 기준이 되는 가장 첫번째 행렬 값을 가져온다

		for (int i = r; i < r + N; i++) {
			for (int j = c; j < c + N; j++) {
				if (map[i][j] != pivot) { // 기준과 같지 않다면
					return false;
				}
			}
		}

		return true;

	}

}
