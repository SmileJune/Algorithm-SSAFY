package com.ssafy.ehoi;

import java.util.Scanner;

public class Day51_BOJ_S3_9372 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 국가의 수
			int M = sc.nextInt(); // 비행기 종류
			
			int[][] tree = new int[M][2];
			for(int i = 0; i < M; i++) {
				tree[i][0] = sc.nextInt();
				tree[i][1] = sc.nextInt();
			}
			// 최소로 이동하는 경로 : 노드의 개수 -1 = 간선 갯수
			System.out.println(N-1);
		}
		sc.close();
	}
}
