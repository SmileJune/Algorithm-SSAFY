package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1939_중량제한 {
	static int N, M;

	static class Node {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

// 그냥 중량제한이 c라는거지 그게 뭐 다른게 아님.. 그래서 ! 
	static List<Node>[] adjList;
	static int max, min, start, end;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 다음 m개 줄에는 다리에 대한 정보를 나타내는 세 정수 A, B, C,가 주어진다.

		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; ++i) {
			adjList[i] = new ArrayList<>();
		}
		max = 0;
		min = Integer.MAX_VALUE;

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			// 양방향이니까
			adjList[s].add(new Node(e, w));
			adjList[e].add(new Node(s, w));
			max = Math.max(max, w);
			min = Math.min(min, w);
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		binary();

	}

	private static void binary() {
		int ans = 0;
		while (min <= max) {
			int mid = (min + max) / 2;
			visited = new boolean[N + 1];
			if (bfs(mid)) {
				min = mid + 1;
				ans = mid;
			} else {
				max = mid - 1;
			}
		}

		System.out.println(ans);
	}

	// 걍 되나 안되나만 보는거잖어.
	private static boolean bfs(int mid) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == end) {
				return true; // 일단 여기까지 올수는 있는거다. 그냥 올수만 있으면 true를 반환해준다.
			}
			for (Node node : adjList[now]) {
				if (node.w >= mid && !visited[node.v]) {
					// 만약에 방문하지않았으면. // 방문했으면 찾을 필요는 없으니까.
					visited[node.v] = true;
					q.add(node.v);
				}
			}
		}
		return false;
	}

}
