package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Day69_BOJ_G5_10026_BFS_Refactoring {
	static int N;
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		boolean[][][] visit = new boolean[2][N][N];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}

		int[] ans = { 0, 0 };
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[k][i][j]) {
						bfs(i, j, visit[k]);
						ans[k]++;
					}
					if (map[i][j] == 'G')
						map[i][j] = 'R';
					
				}
			}
		}

		System.out.print(ans[0] + " " + ans[1]);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	private static void bfs(int r, int c, boolean[][] visit) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c));
		visit[r][c] = true;
		
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc]) continue;
				if(map[curr.r][curr.c] == map[nr][nc]) {
					q.add(new Node(nr, nc));
					visit[nr][nc] = true;
				}
			}
			
			
			
		}

	}

	
}
