package com.ssafy.ehoi;

import java.util.Scanner;

public class Day58_BOJ_G5_9663 {

	static int N;
	static int[][] map;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		ans = 0;

		// 0번째 행에 퀸을 놓자
		dropTheQueen(0);
		
		System.out.println(ans);

		sc.close();
	}

	private static void dropTheQueen(int r) {
		// 체스를 다 놓았다면
		if (r == N) {
			ans++;
			return;
		}

		// 한 행씩 체스를 놓자
		// 무슨 열에 놓을까?
		for (int c = 0; c < N; c++) {
			// 여기에 놓아도 될까?
			if (check(r, c)) {
				// 놓아도 되면 놓고
				map[r][c] = 1;
				// 다음 행에 놓으러 들어가자
				dropTheQueen(r+1);
				// 놓고 나온 다음에는 치우자
				map[r][c] = 0;
			}
		}

	}

	// 현재 내가 놓으려고 하는 위치의 왼쪽위, 위, 오른쪽 위를 주우우욱 탐색하자
	// r은 하나씩 줄어들면 되고 0까지
	// c는 방향에 따라 -1, 0, +1이야
	private static boolean check(int r, int c) {
		int left = c;
		int right = c;

		for (int i = r - 1; i >= 0; i--) {
			left--;
			right++;
			// 왼쪽부터, 아 범위체크부터 : 근데 범위를 나가는 게 false는 아니야 
			// 범위 안에 들어와 있는데, 놓여 있으면 그게 false지
			if (left >= 0 && map[i][left] == 1) return false;
			// 이제 위
			if (map[i][c] == 1) return false;
			if (right < N && map[i][right] == 1) return false;
		}
		// 무사 통과했다면 놓을 수 있어
		return true;

	}
}
