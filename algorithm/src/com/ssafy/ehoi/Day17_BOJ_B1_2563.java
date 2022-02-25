package com.ssafy.ehoi;

import java.util.Scanner;

public class Day17_BOJ_B1_2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 색종이 수
		int[][] paper = new int[101][101]; // 도화지 생성
		
		for (int i = 0; i < N; i++) {
			int c = sc.nextInt();
			int r = sc.nextInt();
			
			for (int j = r; j < r+10; j++) {
				for (int k = c; k < c+10; k++) {
					paper[j][k] = 1;
				}
			}
		} // 색종이 1로 색칠 완료
		
		int cnt = 0;
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper.length; j++) {
				if(paper[i][j] == 1) cnt++;
			}
		}
		
		System.out.println(cnt);
		sc.close();
	}
}
