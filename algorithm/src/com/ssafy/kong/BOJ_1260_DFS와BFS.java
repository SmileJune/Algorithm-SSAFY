package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	static int N, M, V;
	static int[][] line;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		line = new int[N+1][N+1];
		visit = new boolean[1001];
		for (int i = 1; i <= M; ++i) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			line[s][e] = line[e][s] = 1;
		}
		DFS(V);
		System.out.println(sb);
		sb = new StringBuilder();
		Arrays.fill(visit, false);
		BFS(V);
		System.out.println(sb);

	}

	static void DFS(int d) {
		visit[d] = true;
		sb.append(d).append(" ");
		for (int i = 1; i <= N; ++i) {
			if(line[d][i] == 1 && !visit[i]) {
				DFS(i);
			}
		}

	}

	static void BFS(int b) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(b);
		visit[b] = true;
		sb.append(b).append(" ");
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int i = 1; i <= N; ++i) {
				if(line[tmp][i] == 1 && !visit[i]) {
					q.add(i);
					visit[i] = true;
					sb.append(i).append(" ");
				}
			}
		}
	}
}