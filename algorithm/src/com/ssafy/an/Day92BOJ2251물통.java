package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day92BOJ2251물통 {
	static int A, B, C;
	static boolean[][][] visited;
	static Queue<int[]> q;
	static PriorityQueue<Integer> ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		visited = new boolean[A + 1][B + 1][C + 1];
		q = new LinkedList<>();
		ans = new PriorityQueue<>();

		bfs();

		while (!ans.isEmpty())
			sb.append(ans.poll() + " ");
		System.out.println(sb);
		br.close();
	}

	private static void bfs() {
		q.add(new int[] { 0, 0, C });
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int a = tmp[0], b = tmp[1], c = tmp[2];
			if (visited[a][b][c])
				continue;
			visited[a][b][c] = true;

			if (a == 0) ans.add(c);

			if (a + b > A) q.add(new int[] { A, a + b - A, c });
			else q.add(new int[] { a + b, 0, c });

			if (a + b > B) q.add(new int[] { a + b - B, B, c });
			else q.add(new int[] { 0, a + b, c });

			if (a + c > A) q.add(new int[] { A, b, a + c - A });
			else q.add(new int[] { a + c, b, 0 });

			if (a + c > C) q.add(new int[] { a + c - C, b, C });
			else q.add(new int[] { 0, b, a + c });

			if (b + c > B) q.add(new int[] { a, B, b + c - B });
			else q.add(new int[] { a, b + c, 0 });

			if (b + c > C) q.add(new int[] { a, b + c - C, C });
			else q.add(new int[] { a, 0, b + c });
		}
	}
}
