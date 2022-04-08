package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	static int R, C;
	static int max = 0;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static List<Character> sel;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		sel = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0 ; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		check(0,0,1);
		System.out.println(max);
	}
	public static void check(int r, int c, int cnt) {
		visited[r][c] = true;
		sel.add(map[r][c]);
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr == R || nc < 0 || nc == C || visited[nr][nc]) continue;
			boolean contain = false;
			for (int j = 0; j < sel.size(); j++) {
				if (map[nr][nc] == sel.get(j)) contain = true;
			}
			if (!contain) {
				check(nr, nc, cnt+1);
			}
		}
		max = Math.max(max, cnt);
		visited[r][c] = false;
		sel.remove(sel.size()-1);
	}
}
