package com.ssafy.ehoi;

import java.util.Scanner;

public class Day18_BOJ_S2_16926 {
	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int R = sc.nextInt();

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		// R만큼 회전 메서드에 집어 넣기
		for(int i = 0; i < R; i++) {
			rotate(arr);
		}

		sc.close();
	}

	// 회전 메서드
	// 논리는
	// 시작인덱스[0,0]부터는 열부터 증가시킨다. 
	// 열의 마지막 인덱스면 행을 증가시킨다. 
	// 행의 마지막 인덱스면 열을 감소시킨다.
	// 열의 인덱스가 0 이면 행을 감소시킨다. 
	// 시작인덱스[0,0]이 되면 그만
	static void rotate(int[][] arr) {
		// 돌리는 범위가 달라
		// 겉에꺼
		// 안에꺼
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
//				if()
			}
		}
		
		
		
		
		
	}

}
