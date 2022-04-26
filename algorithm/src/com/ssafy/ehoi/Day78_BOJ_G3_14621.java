package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day78_BOJ_G3_14621 {
	static class Node implements Comparable<Node> {
		int s, e, c;

		public Node(int s, int e, int c) {
			this.s = s;
			this.e = e;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return this.c - o.c;
		}

	}

	static int p[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 학교 수
		int M = Integer.parseInt(st.nextToken()); // 도로의 개수

		p = new int[N + 1];
		for (int i = 1; i <= N; i++)
			p[i] = i;

		char[] gender = new char[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			gender[i] = st.nextToken().charAt(0);
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			pq.add(new Node(s, e, c));
		}
		
		int pick = 0; // 선택된 간선의 개수
		int dist = 0;
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (gender[curr.s] == gender[curr.e]) //연결된 두 학교가 같은 성별 대학교라면 바이
				continue;
			if (findSet(curr.s) == findSet(curr.e)) continue;
			union(curr.s, curr.e);
			dist += curr.c;
			pick++;
		}
		
		// 다 뽑고도 간선의 개수가 정점 - 1이 안된다면
		System.out.println(pick < N - 1 ? -1 : dist);

	}

	private static void union(int x, int y) {
		p[findSet(x)] = findSet(y);
	}

	private static int findSet(int x) {
		return p[x] = p[x] == x ? x : findSet(p[x]);
	}
}
