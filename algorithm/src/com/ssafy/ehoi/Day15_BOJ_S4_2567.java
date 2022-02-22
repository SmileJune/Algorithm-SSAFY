package com.ssafy.ehoi;

import java.util.Scanner;

public class Day15_BOJ_S4_2567 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 색종이 수
		int[][] paper = new int[102][102]; // 종이 양쪽에 1씩 여유 공간두고 만듬
		for (int i = 0; i < N; i++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			for (int r = row; r < row + 10; r++) {
				for (int c = col; c < col + 10; c++) {
					paper[r][c] = 1;
				}
			}
		} // 색종이 네 장 다 종이에 올려놓기 완성!
		
		// 이제 도화지 돌아다니면서 색종이(1) 상하좌우가 0 인곳을 찾아 cnt 세어줘야지
		int cnt = 0;
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper.length; j++) {
				if(paper[i][j] == 1) { // 색종이라면? 
					if(paper[i-1][j] == 0) cnt++; // 상
					if(paper[i+1][j] == 0) cnt++; // 하
					if(paper[i][j-1] == 0) cnt++; // 좌
					if(paper[i][j+1] == 0) cnt++; // 우
				}
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
