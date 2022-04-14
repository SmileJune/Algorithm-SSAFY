package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_5656_벽돌깨기 {
	static int N, W, H, cnt;
	static int[][] map, copy;
	static Queue<int[]> queue;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] sel;
	static int ans, min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		for (int tc =1 ;tc <= T; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			copy = new int[H][W];
			cnt = 0;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0) cnt++;
				}
			}
			queue = new LinkedList<int[]>();
			sel = new int[N];
			min = Integer.MAX_VALUE;
			perm(0,0);
			sb.append("#" + tc + " " + min + "\n");
			
		}
		System.out.println(sb);
	}
	public static void perm(int idx, int sidx) {
		if (idx == N) {
			ans = cnt;
			for (int i = 0; i < map.length; i++) {				
				System.arraycopy(map[i], 0, copy[i], 0, map[i].length);
			}
			for (int i = 0; i < N; i++) {
				shoot(sel[i]);
			}
			min = Math.min(min, ans);
			return;
		}
		for (int i = sidx; i < W; i++) {
			sel[idx] = i;
			perm(idx+1, sidx);
		}
	}
	public static void shoot(int c) {
		for (int i = 0; i < H; i++) {
			if (copy[i][c] != 0) {
				bomb(i,c);
				break;
			}
		}
	}
	private static void bomb(int r, int c) {
		queue.add(new int[] {r,c});
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int pr = temp[0];
			int pc = temp[1];
			int range = copy[pr][pc];
			if (copy[pr][pc] != 0) {				
				ans--;
			}
			copy[pr][pc] = 0;
			int nr = 0;
			int nc = 0;
			for (int j = 1; j < range; j++) {
				for (int i = 0; i < 4; i++) {
					nr = pr + j * dr[i];
					nc = pc + j * dc[i];
					if (nr < 0 || nr > H-1 || nc < 0 || nc > W-1) continue;
					if (copy[nr][nc] != 0) {
						queue.add(new int[] {nr, nc});
					}
				}
			}
		}
		for (int j = 0; j < W; j++) {
			for (int k = H-1; k >= 0; k--) {
				if (copy[k][j] == 0) {
					int kidx = 1;
					while(k-kidx >= 0) {
						if (copy[k-kidx][j] != 0) {
							copy[k][j] = copy[k-kidx][j];
							copy[k-kidx][j] = 0;
							break;
						}
						kidx++;
					}
				}
			}
		}
	}
}
