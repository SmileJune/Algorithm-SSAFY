package com.ssafy.hwang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Day55_BOJ_DFS와BFS {
	static class Node {
		List<Integer> adjacent = new ArrayList<>();
	}

	static int N;
	static Node[] graph;
	static boolean[] marked;
	static Queue<Integer> queue = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		graph = new Node[N + 1];
		marked = new boolean[N + 1];
		for(int i =0; i<N+1;i++) {
			graph[i] = new Node();
		}
		while(M-->0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].adjacent.add(b);
			graph[b].adjacent.add(a);
			
		}
		for (int i = 1; i <= N; i++) {
			if (graph[i] != null) {
				Collections.sort(graph[i].adjacent);
			}
		}
		dfs(V);
		sb.append("\n");
		Arrays.fill(marked, false);
		bfs(V);
		System.out.println(sb);
	}

	

	private static void dfs(int idx) {
		if(marked[idx] == true) return;
		marked[idx] = true;
		sb.append(idx+" ");
		for(int i =0; i<graph[idx].adjacent.size(); i++) 
				dfs(graph[idx].adjacent.get(i));
			
		
		
	}

	private static void bfs(int idx) {
		queue.offer(idx);
		marked[idx] = true;
		
		while(!queue.isEmpty()) {
			idx = queue.poll();
			sb.append(idx+" ");
			for(int i = 0 ; i<graph[idx].adjacent.size();i++) {
				int tmp = graph[idx].adjacent.get(i);
				if(!marked[tmp]) {
					queue.offer(tmp);
					marked[tmp]=true;
				}
			}
		}
	}
}
