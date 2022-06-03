package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day37BOJ13460구슬탈출2구현문제bfs { // 13460 구슬탈출 2
	static int N, M;
	static char[][] map;
	static boolean[][][][] visited;
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[10][10][10][10];

		Node node = new Node();
		node.cnt = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R') {
					node.rIdx = i;
					node.rJdx = j;
				} else if (map[i][j] == 'B') {
					node.bIdx = i;
					node.bJdx = j;
				}
			}
		}
		bfs(node);
		br.close();
	}

	private static void bfs(Node ball) {
		Queue<Node> q = new LinkedList<>();
		q.offer(ball);

		while (!q.isEmpty()) {
			Node node = q.poll();
			visited[node.rIdx][node.rJdx][node.bIdx][node.bJdx] = true;

			if (node.cnt >= 10) {
				System.out.println(-1);
				return;
			}

			for (int dir = 0; dir < 4; dir++) {

				int bi = node.bIdx;
				int bj = node.bJdx;
				while (map[bi + dr[dir]][bj + dc[dir]] != '#') {
					bi += dr[dir];
					bj += dc[dir];
					if (map[bi][bj] == 'O')
						break;
				}
				int ri = node.rIdx;
				int rj = node.rJdx;
				while (map[ri + dr[dir]][rj + dc[dir]] != '#') {
					ri += dr[dir];
					rj += dc[dir];
					if (map[ri][rj] == 'O')
						break;
				}

				if (map[bi][bj] == 'O') {

					continue;
				}

				if (map[ri][rj] == 'O') {
					System.out.println(node.cnt + 1);
					return;
				}

				if (ri == bi && rj == bj) {
					switch (dir) {
					case 0:
						if (node.rIdx > node.bIdx)
							ri++;
						else
							bi++;
						break;
					case 1:
						if (node.rIdx > node.bIdx)
							bi--;
						else
							ri--;
						break;
					case 2:
						if (node.rJdx > node.bJdx)
							rj++;
						else
							bj++;
						break;
					case 3:
						if (node.rJdx > node.bJdx)
							bj--;
						else
							rj--;
					}
				}

				if (!visited[ri][rj][bi][bj]) {
					q.offer(new Node(ri, rj, bi, bj, node.cnt + 1));
				}
			}

		}
		System.out.println(-1);
	}
}

class Node {
	int rIdx, rJdx;
	int bIdx, bJdx;
	int cnt;

	public Node() {
	}

	public Node(int rIdx, int rJdx, int bIdx, int bJdx, int cnt) {
		this.rIdx = rIdx;
		this.rJdx = rJdx;
		this.bIdx = bIdx;
		this.bJdx = bJdx;
		this.cnt = cnt;
	}
}