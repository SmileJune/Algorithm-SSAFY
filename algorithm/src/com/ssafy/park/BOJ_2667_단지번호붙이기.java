package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2667_단지번호붙이기 {
	static int n;
	static int[][] maps;
	static boolean[][] visited;
	
	static int total=0; 
	static int cnt;
	static List<Integer> cnts = new ArrayList<>();
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1}; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		n = Integer.parseInt(str);
		
		maps = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			str = br.readLine();
			for(int j=0; j<n; j++) {
				maps[i][j]=Integer.parseInt(str.split("")[j]);
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				cnt = 0;
				if(maps[i][j]==1 && !visited[i][j]) {
					total++;
					cnt++;
					dfs(i, j);
					cnts.add(cnt);
				}
			}
		}
		
		System.out.println(total);
		Collections.sort(cnts);
		for(int i=0; i<cnts.size(); i++) {
			System.out.println(cnts.get(i));
		}
		
	}
	
	static void dfs(int cy, int cx) {
		
		visited[cy][cx] = true;
		
		int ny, nx;
		for(int i=0; i<4; i++) {
			ny = cy + dy[i];
			nx = cx + dx[i];
			
			if(ny>=0 && ny<n && nx>=0 && nx<n) {
				if(!visited[ny][nx] && maps[ny][nx]==1) {
					cnt++;
					dfs(ny, nx);
				}
			}
		}
		
	}

}