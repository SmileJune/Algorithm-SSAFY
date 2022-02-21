package com.ssafy.ehoi;

import java.util.Scanner;

public class Day14_B1_10163_ColorPaper {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 색종이 장수

		int[][] paper = new int[1001][1001]; // 평면
		for (int p = 1; p <= N; p++) { // 색종이 장수 만큼
			int x = sc.nextInt(); // 기준점 행
			int y = sc.nextInt(); // 기준점 열
			int w = sc.nextInt(); // 너비
			int h = sc.nextInt(); // 높이

			for (int i = x; i < x+w; i++) {
				for (int j = y; j < y+h; j++) {
					paper[i][j] = p; // 평면에 색종이 번호 입력 // 뒤에 나오는 색종이들이 그 위를 덮게 됨
				}
			}

		} // 색종이 올리기 끝
		
		// 이제 색종이 숫자를 세어보자
		for (int k = 1; k <= N; k++) { // 색종이 1번부터
			int cnt = 0; // 카운트를 0으로 초기화 하고
			for (int i = 0; i < paper.length; i++) { // 평면 가로
				for (int j = 0; j < paper.length; j++) { // 평면 세로 돌면서
					if (paper[i][j] == k) { // 그 평면을 색종이 1번이 가장 위에 올라와 있다면 세어줘라.
						cnt ++ ;
					}
				}
			} // 한 색종이 다 셌어
			System.out.println(cnt); // 그 종이에 대한 면적 
		}


		sc.close();
	}
}
