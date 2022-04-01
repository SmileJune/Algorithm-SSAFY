package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Day53BOJ4803트리 {
	static int N, M;
	static int isTree = 0, cnt = 0;
	static List<Integer>[] tree;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			isTree = 0;
			cnt = 0;

			if (N == 0)
				break;

			tree = new ArrayList[N + 1];
			visited = new boolean[N + 1];

			for (int i = 1; i < N + 1; i++) {
				tree[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());

				tree[n1].add(n2);
				tree[n2].add(n1);
			}

			for (int i = 1; i < N + 1; i++) {
				if (!visited[i]) {
					visited[i] = true;
					if (dfs(0, i))
						isTree++;
				}
			}
			
			sb.append("Case ").append(tc++).append(": ");
			if(isTree == 0)
				sb.append("No trees.\n");
			else if(isTree == 1)
				sb.append("There is one tree.\n");
			else
				sb.append("A forest of ").append(isTree).append(" trees.\n");
		}

		System.out.println(sb);
		br.close();
	}

	private static boolean dfs(int root, int num) {
		for (int i = 0; i < tree[num].size(); i++) { // 자식의 갯수를 모름.
			int t = tree[num].get(i);
			if(t == root) continue; // 받은 값이 현재위치면 넘어가도록
			if(visited[t]) return false; // 현재 값이 이미 방문했던 값이면 아래는 이번에 볼 필요 없음.
			visited[t] = true; //현재값을 방문처리
			if(!dfs(num, t)) return false; // 현재 num이 루트인 서브트리 탐색
		}
		return true; // 서브트리 포함 하나라도 false가 아니면 tree
	}
}
