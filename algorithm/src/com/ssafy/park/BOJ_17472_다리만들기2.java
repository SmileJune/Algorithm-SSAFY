package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472_다리만들기2 {
	public static class point{
		int r, c, dist;

		public point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public point(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	static int N, M;
	static int[][] map;
	static boolean[][] check;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] parent;
	static Queue<point> queue;
	static List<int[]> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		check = new boolean[N][M];
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !check[i][j]) {
					islandCheck(i, j, cnt);
					cnt++;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					Bridge(i, j, map[i][j]);
				}
			}
		}
		parent = new int[cnt];
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] > o2[2]) {
					return 1;
				} else if (o1[2] < o2[2]) {
					return -1;
				}
				return 0;
			}
		});
		int acnt = 1;
		int ans = 0;
		for (int i = 0; i < list.size(); i++) {
			int a = list.get(i)[0];
			int b = list.get(i)[1];
			if (findSet(a) == findSet(b))
				continue;
			unionSet(a, b);
			acnt++;
			ans += list.get(i)[2];

			if (acnt == cnt - 1)
				break;
		}
		for (int i = 2; i < parent.length; i++) {
			if ( parent[1] != findSet(parent[i])) {
				ans = -1;
			}
		}
		System.out.println(ans);
	}
	public static void islandCheck(int r, int c, int cnt) {
		queue = new LinkedList<>();
		queue.add(new point(r,c));
		map[r][c] = cnt;
		check[r][c] = true;
		
		while(!queue.isEmpty()) {
			point p = queue.poll();
			int pr = p.r;
			int pc = p.c;
			
			for (int i = 0; i < 4; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];
				if (nr < 0 || nr == N || nc < 0 || nc == M || check[nr][nc]) continue;
				
				if (map[nr][nc] == 1) {
					map[nr][nc] = cnt;
					check[nr][nc] = true;
					queue.add(new point(nr, nc));
				}
			}
		}
	}
	public static void Bridge(int r, int c, int idx) {
		queue = new LinkedList<>();
		check = new boolean[N][M];
		for (int i = 0; i < 4; i++) {
			queue.add(new point(r, c, 0));
			check[r][c] = true;
			while(!queue.isEmpty()) {
				point p = queue.poll();
				int pr = p.r;
				int pc = p.c;
				int pdist = p.dist;
				
				int nr = pr + dr[i];
				int nc = pc + dc[i];
				if (nr < 0 || nr == N || nc < 0 || nc == M || check[nr][nc]) continue;
				if (map[nr][nc] != idx) {					
					if (map[nr][nc] != 0) {
						int[] temp = new int[3];
						temp[0] = idx;
						temp[1] = map[nr][nc];
						temp[2] = pdist;
						if (pdist > 1) {
							list.add(temp);
							break;
						}
					} else {
						check[nr][nc] = true;
						queue.add(new point(nr,nc,pdist+1));
					}
				}
			}
		}
	}
	public static int findSet(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = findSet(parent[x]);
	}

	public static void unionSet(int x, int y) {
		int dx = findSet(x);
		int dy = findSet(y);
		parent[dy] = dx;
	}
}
