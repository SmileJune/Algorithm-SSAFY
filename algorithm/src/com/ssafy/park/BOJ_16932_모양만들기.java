package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16932_모양만들기 {
	static int N, M, ans;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<int[]> queue;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    map = new int[N][M];
	    for (int i = 0; i < N; i++) {
	    	st = new StringTokenizer(br.readLine()," ");
	    	for (int j = 0; j < M; j++) {
	    		map[i][j] = Integer.parseInt(st.nextToken());
	    	}
	    }
	    ans = 0;
	    queue = new LinkedList<int[]>();
	    
	    check();
	    System.out.println(ans);
	}
	
	public static void check() {
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					int cnt = 0;
					queue.add(new int[] {i, j});
					visited[i][j] = true;
					while(!queue.isEmpty()) {
						int[] arr = queue.poll();
						cnt++;
						int r = arr[0];
						int c = arr[1];
						for (int k = 0; k < 4; k++) {
							int mdr = r + dr[k];
							int mdc = c + dc[k];
							if (mdr < 0 || mdr >= N || mdc < 0 || mdc >= M) continue;
							if (map[mdr][mdc] == 1 && !visited[mdr][mdc]) {
								queue.add(new int[] {mdr, mdc});
								visited[mdr][mdc] = true;
							}
						}
					}
					ans = Math.max(ans, cnt);
				} else continue;
				visited = new boolean[N][M];
			}
		}
	}
}
