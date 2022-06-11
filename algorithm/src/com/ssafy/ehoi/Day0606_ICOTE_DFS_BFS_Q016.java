package com.ssafy.ehoi;

import java.util.Arrays;
import java.util.Scanner;

public class Day0606_ICOTE_DFS_BFS_Q016 {
	static int n, m;
	static int result = 0;
	static int arr[][] = new int[8][8];
	static int temp[][] = new int[8][8];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		} // 입력 끝

		makeWall(0);
		System.out.println(result);

		sc.close();

	}

	private static void makeWall(int cnt) {
		if (cnt == 3) {
//			System.out.println(Arrays.deepToString(arr));
			// 바이러스를 퍼뜨려볼 공간을 복사하자
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					temp[i][j] = arr[i][j];
				}
			}

			// 2인 곳을 찾아서 보내기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (temp[i][j] == 2) {
						virus(i, j);
					}
				}
			}
//			System.out.println(Arrays.deepToString(temp));

			// 0의 개수 세기
			result = Math.max(result, count0());
			return;
		}
		// 벽을 세우자
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) { // 빈칸이라면
					arr[i][j] = 1;
					makeWall(cnt + 1);
					arr[i][j] = 0; // 진행하고 와서는 다시 빈칸인 그대로 두기
				}
			}
		}

	}

	private static int count0() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(temp[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}


	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void virus(int r, int c) {

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
			if (temp[nr][nc] != 0) continue;
			temp[nr][nc] = 2;
			virus(nr, nc);
		}
	}

}