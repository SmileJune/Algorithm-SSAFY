package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day155BOJ1753다익스트라구현 {
	private static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		List<List<Node>> list = new ArrayList<>(V + 1);
		for (int i = 0; i <= V; i++) {
			list.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
		
			list.get(from).add(new Node(to, weight));
		}
		
		int[] dist = new int[V + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if (dist[cur.no] < cur.dist) 
				continue;

			for (Node curNode : list.get(cur.no)) {
				int to = curNode.to;
				int addDist = curNode.w;
				
				if (dist[to] > dist[cur.no] + addDist) {
					dist[to] = dist[cur.no] + addDist;
					pq.add(new Edge(to, dist[to]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(dist[i] == INF ? "INF" : dist[i]).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static class Node {
		int to, w;

		public Node(int to, int w) {
			this.to = to;
			this.w = w;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int no, dist;

		public Edge(int no, int dist) {
			super();
			this.no = no;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Edge o) {
			return dist - o.dist;
		}
	}
}