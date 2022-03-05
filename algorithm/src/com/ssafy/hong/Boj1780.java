package com.ssafy.hong;
import java.util.*;

public class Boj1780 {
	
	
	static int[][] map;
	static int[] ans = new int[4];
	static int[] dy = {0,0,0,1,1,1,2,2,2};
	static int[] dx = {0,1,2,0,1,2,0,1,2};
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt() + 1;
			}
		}
		ans[paper(0,0,N)]++;
		for(int i=0; i<3; i++)System.out.println(ans[i]);
	}
	
	static int paper(int y, int x, int size) {
		if(size == 1)return map[y][x];
		
		int[] temp = new int[4];
		size /= 3;
		for(int i=0; i<9; i++) {
			temp[paper(y+dy[i]*size,x+dx[i]*size,size)]++;
		}
		
		for(int i=0; i<3; i++) {
			if(temp[i] == 9) {
				return i;
			}
			ans[i] += temp[i];
		}
		
		return 3;
	};
	
}
