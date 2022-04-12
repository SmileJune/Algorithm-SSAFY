package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_3124_최소스패닝트리 {
	static class Edge {
		int x, y, value;

		public Edge(int start, int end, int value) {
			this.x = start;
			this.y = end;
			this.value = value;
		}
	}
	static int V, E;
	static long ans;
	static int[] parent;
	static Edge[] edge;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			ans = 0;
			parent = new int[V + 1];
			edge = new Edge[E];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				edge[i] = new Edge(s, e, v);
			}
			makeSet();
			Arrays.sort(edge, (a, b) -> a.value - b.value);
			int cnt = 0;
			for (int i = 0; i < E; i++) {
				Edge e = edge[i];
				if (findSet(e.x) == findSet(e.y)) continue;
				union(e.x, e.y);
				cnt++;
				ans += e.value;
				
				if (cnt == V-1) break;
			}
			System.out.println("#"+t+" "+ans);
		}
	}

	static void makeSet() {
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}

	static int findSet(int x) {
		if (parent[x] == x)
			return x;
		else
			return parent[x] = findSet(parent[x]); 
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (px < py)
			parent[py] = px;
		else
			parent[px] = py;
	}

	
}
