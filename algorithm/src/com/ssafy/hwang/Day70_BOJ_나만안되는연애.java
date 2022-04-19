package com.ssafy.hwang;

import java.util.Arrays;
import java.util.Scanner;

public class Day70_BOJ_나만안되는연애 {
	static int[] p;
	static class Edge implements Comparable<Edge>{
		int st;
		int ed;
		int weight;
		public Edge(int st, int ed, int weight) {
			this.st = st;
			this.ed = ed;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// 성별만을 순서대로 저장해 두는 배열
		String[] sex = new String[N+1];
		for(int i =1;i<=N;i++) {
			sex[i] = sc.next();
		}
		
		Edge[] edges = new Edge[M];
		
		for(int i =0; i<M;i++) {
			edges[i] = new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(edges);
		
		p = new int[N+1];
		for(int i =1; i<=N;i++) {
			p[i] = i;
		}
		int ans =0 ;
		int edgeCnt=0;
		for(int i =0; i<M;i++) {
			int px = findSet(edges[i].st);
			int py = findSet(edges[i].ed);
			if(px != py && !sex[edges[i].st].equals(sex[edges[i].ed])) {
				union(px,py);
				ans += edges[i].weight;
				edgeCnt++;
			}
		}
		ans = (edgeCnt != N-1) ? -1 : ans;
		System.out.println(ans);
		
	}
	private static void union(int x, int y) {
		p[y] = x;
	}
	private static int findSet(int x) {
		if(p[x]!=x) p[x] = findSet(p[x]);
		return p[x];
	}
	
}











