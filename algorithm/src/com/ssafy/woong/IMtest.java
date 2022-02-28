package com.ssafy.woong;
import java.util.Scanner;

/*
 *  통로 0
 *  벽 1
 *  경비 2
 *  경비원의 범위: 상하좌우, 거리 : 무한
 *  문제: 경비원이 감시하지 못하는 통로의 갯수 
 *  한변의 길이 : 5 <= N <= N
*/
public class IMtest{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d\n",tc,solution());
		}
	}
	
	static int solution() {
		
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		int n = sc.nextInt(); // 변의 길이 받기
		int[][] map = new int[n][n];
		int spaceCnt = 0; // 총 통로 갯수
		int[] pos = null; //경비원 위치
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 0)spaceCnt++;
				if(map[i][j] == 2)pos = new int[] {i,j};
			}
		}
		
		for(int i = 0; i < 4; i++) {
			int ny = pos[0] + dy[i];
			int nx = pos[1] + dx[i];
			while(ny < n && nx < n && ny >= 0 && nx >= 0 && map[ny][nx] == 0) {
				spaceCnt--;
				ny += dy[i];
				nx += dx[i];
			}
		}
		return spaceCnt;
	}
}
