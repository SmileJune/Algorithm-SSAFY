package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Day96BOJ14465지름길 { // 1446 지름길
	static class Node {
		int e, c;
		public Node(int e, int c) {
			this.e = e;
			this.c = c;
		}
	}
	static int N, D;
	static int[] dist;
	static List<Node>[] node;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		dist = new int[D + 1];
		node = new ArrayList[D + 1]; // List 인덱스를 s로 조작
		for (int i = 0; i < D + 1; i++) {
			dist[i] = i;
			node[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if (e > D) continue;
			int c = Integer.parseInt(st.nextToken());
			if(c < e - s)
				node[s].add(new Node(e, c));
		}
		for (int i = 0; i < D + 1; i++) {
			if (i != 0) 
				dist[i] = Math.min(dist[i], dist[i - 1] + 1);
			if (node[i].size() > 0) 
				for (Node n : node[i]) 
					dist[n.e] = Math.min(dist[n.e], dist[i] + n.c);
//			System.out.println(Arrays.toString(dist).replaceAll("[\\[\\],ull]", ""));
		}
		System.out.println(dist[D]);
		br.close();
	}
}
