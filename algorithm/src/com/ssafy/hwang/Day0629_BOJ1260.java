package com.ssafy.hwang;

import java.util.*;

public class Day0629_BOJ1260 {
	static class Node{
		List<Integer> adjacent = new ArrayList<>();
	}
	private static boolean[] marked;
	private static StringBuilder sb;
	private static Node[] graph;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		graph = new Node[N+1];
		marked = new boolean[N+1];
		sb = new StringBuilder();
		for(int i = 0 ; i<N;i++) {
			graph[i] = new Node();
		}
		for(int i = 0; i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].adjacent.add(b);
			graph[b].adjacent.add(a);
		}
		for(int i = 1; i<=N; i++) {
			if(graph[i]!=null) {
				Collections.sort(graph[i].adjacent);
			}
		}
		dfs(V);
		System.out.println(sb);
	}
	private static void dfs(int idx) {
		if(marked[idx] == true) return;
		marked[idx] = true;
		sb.append(idx+" ");
		for(int i = 0 ; i<graph[idx].adjacent.size();i++) {
			dfs(graph[idx].adjacent.get(i));
		}
	}

}
