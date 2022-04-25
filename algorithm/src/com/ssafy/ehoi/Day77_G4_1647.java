package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Day77_G4_1647 {
	
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
	
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = sc.nextInt(); // 노드 개수
		int M = sc.nextInt(); // 간선 개수

		p = new int[N + 1];
		for (int i = 0; i <= N; i++)
			p[i] = i; // makeSet

		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int c = sc.nextInt();

			pq.add(new Node(s, e, c));
		}

		int cost = 0;
		int pick = 0;
		while (pick < N - 2) {
			Node curr = pq.poll();
			if (findSet(curr.s) == findSet(curr.e))
				continue;
			union(curr.s , curr.e);
			cost += curr.c;
			pick++;
		}
		System.out.println(cost);
		sc.close();
	}

	private static void union(int x, int y) {
		p[findSet(x)] = findSet(y);
	}

	private static int findSet(int x) {
		return p[x] = p[x] == x ? x : findSet(p[x]);
	}
	
	
}
