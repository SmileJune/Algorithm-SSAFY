package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2252_줄세우기 {
	static int V, E;
	static List<Integer>[] adjList;
	static Stack<Integer> ans;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[V+1];
		int[] zero = new int[V+1];
		for (int i = 0; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adjList[s].add(e);
			zero[e]++;
		}
		visited = new boolean[V+1];
		ans = new Stack<>();
		for (int i = 1; i < zero.length; i++) {
			if (zero[i] == 0) {
				TopologicalSort(i);
			}
		}
		while(!ans.isEmpty()) {
			sb.append(ans.pop() + " ");
		}
		System.out.println(sb);
	}
	private static void TopologicalSort(int v) {
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
