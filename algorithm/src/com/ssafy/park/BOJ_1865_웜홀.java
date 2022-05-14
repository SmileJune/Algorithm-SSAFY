package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1865_웜홀 {
	static int N, M, W;
	static int dis[];
	static ArrayList<edge>[] road;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			dis = new int[N+1];
			Arrays.fill(dis, 987654321);
			road = new ArrayList[N+1];
			
			for(int j = 0; j < N+1; j++) {
				road[j] = new ArrayList<>();
			}
			
			for(int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()); 
				int b = Integer.parseInt(st.nextToken()); 
				int c = Integer.parseInt(st.nextToken());
				road[a].add(new edge(b, c));
				road[b].add(new edge(a, c));
			}
			
			for(int j = 0; j < W; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken()); 
				int c = Integer.parseInt(st.nextToken());
				road[a].add(new edge(b, -c));
			}
			
			if(bellmanFord()) System.out.println("YES");
			else System.out.println("NO");
			
		}
		

	}
	
	static boolean bellmanFord() {
		dis[1] = 0;
		
		for(int i = 1; i < N; i++) {
			for(int j = 1; j < road.length; j++) {
				for(edge next: road[j]) {
					if(dis[j] + next.time < dis[next.node]) {
						dis[next.node] = dis[j] + next.time;
					}
				}
			}
		}
		
		for(int j = 1; j < road.length; j++) {
			for(edge next: road[j]) {
				if(dis[j] + next.time < dis[next.node]) {
					return true;
				}
			}
		}
		return false;
	}
	
	static class edge{
		int node; 
		int time; 
		
		edge(int node, int time) {
			this.node = node;
			this.time = time;
		}
	}
}