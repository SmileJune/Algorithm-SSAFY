package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;


public class SW_1267_작업순서 {
	
	static int V, E;
	static boolean[] visited;
	static Stack<int[]> mStack;
	static Stack<Integer> ans;
	static List<Integer>[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			adjList = new ArrayList[V+1];
			for (int i = 0; i <= V; i++) {
				adjList[i] = new ArrayList<>();
			}
			visited = new boolean[V+1];
			st = new StringTokenizer(br.readLine()," ");
			int[] zero = new int[V+1];
			for (int i = 0; i < E; i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				adjList[s].add(e);
				zero[e]++; 
			}
			mStack = new Stack<>();
			ans = new Stack<>();
			for (int i = 1; i < zero.length; i++) {
				if (zero[i] == 0) {
					TopologicalSort(i);
				}
			}
			sb.append("#" + tc);
			while(!ans.isEmpty()) {
				sb.append(" " + ans.pop());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void TopologicalSort(int v) {
		visited[v] = true;
		for (int i = 0; i < adjList[v].size(); i++) {
			int u = adjList[v].get(i);
			if (!visited[u]) {
				TopologicalSort(u);
			}
		}
		ans.push(v);
	}
}
