package com.ssafy.ehoi;

import java.util.ArrayList;
import java.util.Scanner;

// 부모 자식간의 관계
// tree : ArrayList
// DFS
public class Day53_BOJ_S2_2644 {
	
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int target;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ans = -1;
		// 노드의 개수
		int N = sc.nextInt();
		graph = new ArrayList<>(N+1);
		// 노드 정점 번호랑 맞추기 위해서 하나 더 크게 생성
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		visited = new boolean[N+1];
		// 시작점
		int start = sc.nextInt();
		// 목표지점
		target = sc.nextInt();
		// 간선 개수
		int k = sc.nextInt();
		for(int i = 0; i < k; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			// 서로가 서로를 자식으로 저장한다 
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		dfs(start, 0);
		
		System.out.println(ans);
		sc.close();
	}
	
	public static void dfs(int val, int depth) {
		// 탐색하러 들어오자마자 방문처리
		visited[val] = true;
		
		// 탐색 중인 현재 노드가 타겟값과 같다면
		if (val == target) {
			ans = depth;
			return;
		}
		
		// 다르다면
		// 나와 연결되어 있는 노드들의 사이즈 만큼 방문할 건데
		for(int i = 0; i < graph.get(val).size(); i++) {
			// 방문한 곳은 안 갈거야
			// 방문할 노드
			int y = graph.get(val).get(i);
			if (!visited[y]) {
				dfs(y, depth + 1);
			}
		}
	}
}
