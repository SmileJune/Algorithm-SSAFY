package com.ssafy.woong;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SM7236IM {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			System.out.printf("#%d %d\n",i,solution());
		}
	}
	
	static int solution() throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[][] w = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
		String[][] map = new String[n][n];
		for(int i = 0 ; i < n ; i++) {
			map[i] = br.readLine().split(" ");
		}
		
		int max = 0;
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				if(map[i][j].equals("W")) {
					int cnt  = 1;
					for(int[] d: w) {
						if(i+d[0] >= 0 && i+d[0] < n && j+d[1] >= 0 && j+d[1] < n && map[i+d[0]][j+d[1]].equals("W")) {
							cnt++;
						}
					}
					if(cnt > max) {
						max = cnt;
					}
				}
			}
		}
		if(max > 1) {
			max--;
		}
		return max;
	}
}