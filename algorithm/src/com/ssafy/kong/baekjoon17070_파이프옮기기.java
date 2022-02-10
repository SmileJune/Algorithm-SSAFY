package com.ssafy.kong;
import java.util.Scanner;

public class baekjoon17070_파이프옮기기 {
	static int[][] map;
	static int N;
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+1][N+1];
		
		for(int i = 1; i <= N; ++i) {
			for(int j = 1; j <= N; ++j) {
				map[i][j] = sc.nextInt();
			}
		}
		if(map[N][N]==1){
            System.out.println(0);
            return;
        }
		findN(1, 2, "가로");
		System.out.println(count);
	}
	static void findN(int col, int row, String direction) {
		if(col == N && row == N) {
			count++;
			return;
		}
		int direc = isDirection(direction);
		// 오른쪽으로 간다.
		if(row+1 <= N  && (direc == 1 || direc == 3)) {
			if(map[col][row+1] != 1) {
				findN(col, (row+1), "가로");
			}
		} 
		// 아래로 간다.
		if(col+1 <= N  && (direc == 2 || direc == 3)) {
			if(map[col+1][row] != 1) {
				findN( (col+1), row, "세로");
			}

		}
		// 대각선으로 간다.
		if((col+1 <= N && row+1 <= N) && (direc != 0) ) {
			if(map[col+1][row+1] != 1 && map[col+1][row] != 1 &&map[col][row+1] != 1) {
				findN((col+1), (row+1), "대각선");
			}
		}
	}
	
	static int isDirection(String direction) {
		switch(direction) {
		case "가로": return 1;
		case "세로": return 2;
		case "대각선": return 3;
		}
		return 0;
	}
	
}
