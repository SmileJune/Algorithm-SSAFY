package com.ssafy.ehoi;

import java.util.Scanner;

public class Day72_BOJ_S3_3085 {
	static char[][] map, copyMap;
	static int N, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		copyMap = new char[N][N];
		ans = 0;
		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}


		// 행 우선 탐색 후 가로 스왑
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (map[i][j] == map[i][j + 1])
					continue;
				swap(i, j, i, j + 1);
				check();
			}
		}
		// 열 우선 탐색 후 세로 스왑
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N - 1; i++) {
				if (map[i][j] == map[i + 1][j])
					continue;
				swap(i, j, i + 1, j);
				check();
			}
		}

		System.out.println(ans);

		sc.close();
	}

	// 가장 긴 사탕의 길이 찾으러 감
	private static void check() {
		// 행 우선 탐색, 열 우선 탐색 다 하면서 최대로 긴 길이 찾기
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			cnt = 1;
			for (int j = 1; j < N; j++) {
				if(copyMap[i][j] == copyMap[i][j-1]) 
					cnt++;
				else cnt = 1; 
				ans = Math.max(ans, cnt);
			}
		}
		
		for (int j = 0; j < N; j++) {
			cnt = 1;
			for (int i = 1; i < N; i++) {
				if(copyMap[i][j] == copyMap[i-1][j]) 
					cnt++;
				else cnt = 1;
				ans = Math.max(ans, cnt);
			}
		}

	}

	private static void swap(int r1, int c1, int r2, int c2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		char tmp = copyMap[r1][c1];
		copyMap[r1][c1] = copyMap[r2][c2];
		copyMap[r2][c2] = tmp;

	}
}

// 사탕의 색이 다른 "인접한" 두 칸을 고른다 
// swap한다
// 그리고 가장 긴 행 또는 열을 찾는다 -> 사탕의 최대 개수를 구한다.