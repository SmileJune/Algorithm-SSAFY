package com.ssafy.hwang;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Day60_BOJ_미로탐색 {
	static int N, M, res, map[][];
	static boolean marked[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<Node> queue;

	static class Node {
		int r;
		int c;
		int cnt;

		public Node(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		res = Integer.MAX_VALUE;
		marked = new boolean[N + 1][M + 1];
		map = new int[N + 1][M + 1];
		for (int i = 1; i < N + 1; i++) {
			String s = sc.nextLine();
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = s.charAt(j - 1) - '0';
			}
		} // 입력 처리 끝
		marked[1][1] = true;
		bfs(1, 1, 1);
		System.out.println(res);
	}

	private static void bfs(int r, int c, int cnt) {
		queue = new LinkedList<>();
		queue.offer(new Node(r, c, cnt));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			r = node.r;
			c = node.c;
			cnt = node.cnt;
			if (r == N && c == M) {
				res = Math.min(res, cnt);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (isNotRange(nr, nc))continue;
				if (marked[nr][nc])continue;
				if (map[nr][nc] == 1) {
					marked[nr][nc] = true;
					queue.add(new Node(nr,nc,cnt+1));
				}
			}
		}
	}

	private static boolean isNotRange(int r, int c) {
		if (r < 0 || c < 0 || r > N || c > M)
			return true;
		return false;
	}
}