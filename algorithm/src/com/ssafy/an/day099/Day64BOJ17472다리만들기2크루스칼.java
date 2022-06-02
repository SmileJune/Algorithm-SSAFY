package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day64BOJ17472다리만들기2크루스칼 {
	static class Node {
		int from, to, len;

		public Node(int from, int to, int len) {
			this.from = from;
			this.to = to;
			this.len = len;
		}
	}

	static int N, M, iCnt = 0, bCnt = 0;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int[][] map;
	static Queue<int[]> q;
	static PriorityQueue<Node> pq;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) - 1;
			}
		}
		// 섬을 구분해야 한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					number(i, j, ++iCnt); // 섬번호 메기기
				}
			}
		}
//		print(map); // 출력용

		// 섬 좌표 별로 모든 가능한 다리 만들어 놓기
		pq = new PriorityQueue<>((o1, o2) -> (o1.len - o2.len));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != -1) {
					makeBri(i, j, map[i][j]); // 섬번호 메기기
				}
			}
		}

		// pq에 가능한 모든 다리 넣어 뒀으니, 가장 짧은 값 구하기 MST Kruskal

		kruskal();

		System.out.println(bCnt == 0 ? -1 : bCnt);
		br.close();
	}
	
	// 섬 별로 번호 메기기 --------------------------------
	private static void number(int idx, int jdx, int num) {
		if (index(idx, jdx))
			return;
		if (map[idx][jdx] == -1 || visited[idx][jdx])
			return;
		map[idx][jdx] = num;
		visited[idx][jdx] = true;
		for (int i = 0; i < 4; i++) {
			int nr = idx + dr[i];
			int nc = jdx + dc[i];
			number(nr, nc, num);
		}
	}
	
	// 가능한 모든 다리 만들어서 되는 것만 pq에 넣어두기 ----------------
	private static void makeBri(int r, int c, int num) {// num : 섬번호
		q = new LinkedList<>();
		visited = new boolean[N][M];
		for (int i = 0; i < 4; i++) {
			q.add(new int[] { r, c, 0 });
			visited[r][c] = true;
			while (!q.isEmpty()) {
				int[] p = q.poll();

				int nr = p[0] + dr[i];
				int nc = p[1] + dc[i];
				int step = p[2];

				if (index(nr, nc) || visited[nr][nc])
					continue;
				if (map[nr][nc] != num) {
					if (map[nr][nc] != -1) { // 바다 아닌 다른 섬
						int from = num - 1;
						int to = map[nr][nc] - 1;
						int len = step;
						if (len > 1) {
							pq.add(new Node(from, to, len));
							break; // 이 정점 끝
						}
					} else { // 바다
						visited[nr][nc] = true;
						q.add(new int[] { nr, nc, step + 1 });
					}
				}
			}
			q.clear(); // 4방향 해야됨.
		}
	}

	// kruskal ------------------------------------------
	static int[] p;

	private static void kruskal() {
		p = new int[iCnt];
		for (int i = 0; i < p.length; i++)
			p[i] = i;

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if (unionSet(node.from, node.to))
				bCnt += node.len;
		}

		for (int i = 1; i < iCnt; i++) {
			if(findSet(0)!=findSet(i))
				bCnt = 0;
		} // union안된 섬이 있는 지 찾기 대표 비교

	}

	private static int findSet(int a) {
		return p[a] = (a == p[a]) ? a : findSet(p[a]);
	}

	private static boolean unionSet(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if (a == b)
			return false;
		p[b] = a;
		return true;
	}

	// util ---------------------------------------------

	private static boolean index(int idx, int jdx) {
		return idx < 0 || idx >= N || jdx < 0 || jdx >= M;
	}

	private static void print(int[][] a) {
		StringBuilder tt = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				tt.append(a[i][j]).append(" ");
			}
			tt.append("\n");
		}
		System.out.println(tt);
	}
}
