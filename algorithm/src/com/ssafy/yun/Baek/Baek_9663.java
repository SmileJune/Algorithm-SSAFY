package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_9663 {

	static Scanner sc = new Scanner(System.in);
	static int[][] map;
	static int N, cnt;

	public static void main(String[] args) {
		N = sc.nextInt();
		map = new int[N][N];

		dropTheQueen(0);
		System.out.println(cnt);
	}

	static void dropTheQueen(int r) {
		if (r == N) {
			cnt++;
			return;
		}

		for (int c = 0; c < N; c++) {
			//확인
			if(!check(r,c)) {
				continue;
			}
			//놓기
			map[r][c] = 1;
			//다음거 놓기
			dropTheQueen(r + 1);
			// 이 단계에 바꿘던 값 돌려놓기
			map[r][c] = 0;
		}
	}
	//11시 12시 1시 체크
	
	static int[] dc = {-1, 0, 1};
	static boolean check(int r, int c) {
		for(int i=0; i<3; i++) {
			int nr = r;
			int nc = c;
			
			while(true) {
				nr -= 1;
				nc += dc[i];
				
				if(nr < 0 || nc < 0 || nc >= N) break;
				if(map[nr][nc]==1) return false;
			}
		}
		return true;
	}

}
