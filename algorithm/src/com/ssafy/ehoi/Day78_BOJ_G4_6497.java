package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * @author belle
 * 최소 스패닝 트리 문제이다
 */
public class Day78_BOJ_G4_6497 {
	static class Node implements Comparable<Node>{
		int s, e, c;

		public Node(int s, int e, int c) {
			super();
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
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken()); // 집의 개수 : 정점
			int n = Integer.parseInt(st.nextToken()); // 길의 수 : 간선
			
			if(m == 0 & n == 0) break; // 종료 조건
			
			// p 배열을 만들자
			p = new int[m];
			for (int i = 0; i < m; i++) p[i] = i;
			
			int total = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				total += c;
				
				pq.add(new Node(s, e, c));
			}
			
			int cost = 0;
			while(!pq.isEmpty()) {
				Node curr = pq.poll();
				
				if(findSet(curr.s) == findSet(curr.e)) continue;
				union(curr.s, curr.e);
				
				cost += curr.c;
			}
			
			System.out.println(total - cost);
			
		}
		
	}

	private static void union(int x, int y) {
		p[findSet(x)] = findSet(y);
	}

	private static int findSet(int x) {
		return p[x] = p[x] == x ? x : findSet(p[x]);
	}
}
