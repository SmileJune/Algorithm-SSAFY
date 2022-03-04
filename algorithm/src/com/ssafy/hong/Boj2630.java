package com.ssafy.hong;
import java.util.*;

public class Boj2630 {
	
	static int[][] map;
	static int[] ans = new int[3];
	static int[] dy = {0,0,1, 1};
	static int[] dx = {0,1,0,1};
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		ans[paper(0,0,N)]++;
		for(int i=0; i<2; i++)System.out.println(ans[i]);
		
	}
	
	static int paper(int y, int x, int size) {
		if(size == 1)return map[y][x];
		
		int[] temp = new int[3];
		size/=2;
		for(int i=0; i<4; i++) {
			temp[paper(y+dy[i]*size, x+dx[i]*size, size)]++;
		}
		
		for(int i=0; i<2; i++) {
			if(temp[i] == 4 )return i;
			ans[i] += temp[i];
		}
		
		return 2;
	}
	
}
