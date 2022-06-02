package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day55BOJ1260DFS와BFS정석으로구현해보기 {
	static int N, M, V;
	static StringBuilder sb;
	static List<Integer>[] list; // 하위 노드 갯수가 불명이므로, List<숫자>로 배열생성
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1]; // 인덱스를 그대로 사용하기 위해 +1
		visited = new boolean[N + 1];

		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		} // 인덱스에 맞게 List에 객체 생성

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			list[n1].add(n2);
			list[n2].add(n1); // 양방향이 가능하므로 서로 원소에 추가
		}

		for (int i = 1; i < N + 1; i++) {
			Collections.sort(list[i]);
		} // 경로가 많을 때 작은 수부터 

		dfs(V);
		sb.append("\n");
		visited = new boolean[N + 1]; // dfs때 사용한 boolean초기화
		bfs(V);

		System.out.println(sb);
		br.close();
	}

	private static void dfs(int v) {
		if (visited[v])
			return; // for문에서 아예 안들어오도록 조건문 가능.
		visited[v] = true; // v를 방문했고,
		sb.append(v).append(" "); // 그 값을 출력
		for (int i : list[v]) { // v의 작은 수 부터 노드에 재귀
			dfs(i);
		}
	}

	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(v); // 처음값 큐에 넣고,
		visited[v] = true; // 방문처리
		
		while (!q.isEmpty()) { // 큐가 빌때까지 실행
			int n = q.poll(); // 현재 큐에서 값을 꺼내서
			sb.append(n).append(" "); // 방문했으니 출력

			for (int i : list[n]) { // 노드를 하나씩 부르고
				if (!visited[i]) { // 방문하지 않는 노드들을 모두 큐에 넣음
					q.offer(i);
					visited[i] = true; // 큐에 들어간 노드는 다시 큐에 넣지 않도록 방문처리 
				}
			}
		}
	}
}
