package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
	static int N, M, ans, vcnt, min, wall;
	static int[][] map, copy;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] sel;
	static List<int[]> virus;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copy = new int[N][M];
		visited = new boolean[N][M];
		virus = new ArrayList<int[]>();
		vcnt = 0;
		wall = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus.add(new int[] {i,j});
					vcnt++;
				}
				if (map[i][j] == 1) {
					wall++;
				}
			}
		}
		sel = new int[3];
		ans = 0;
		min = Integer.MAX_VALUE;
		wall += 3;
		comb(0,0);
		System.out.println(N*M-min-wall);
	}
	public static void comb(int cnt, int start) {
		if (cnt == 3) {
			for (int i = 0; i < map.length; i++) {				
				System.arraycopy(map[i], 0, copy[i], 0, map[i].length);
			}
			for (int i = 0; i < 3; i++) {
				copy[sel[i]/M][sel[i]%M] = 1;
			}
			ans = vcnt;
			visited = new boolean[N][M];
			for (int i = 0; i < virus.size(); i++) {
				cal(virus.get(i)[0], virus.get(i)[1]);
			}
			min = Math.min(ans, min);
			return;
		}
		for (int i = start; i < N*M; i++) {
			sel[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	public static void cal(int r, int c) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr == N || nc < 0 || nc == M || visited[nr][nc]) continue;
			if (copy[nr][nc] == 0) {
				copy[nr][nc] = 2;
				ans++;
				cal(nr, nc);
			}
		}
	}
}
