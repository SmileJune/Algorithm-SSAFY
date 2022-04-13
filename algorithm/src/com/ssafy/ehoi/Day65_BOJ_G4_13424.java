package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Day65_BOJ_G4_13424 {
	static class Node {
		int st, ed, dist;

		public Node(int ed, int dist) {
			this.ed = ed;
			this.dist = dist;
		}

	}

	static int[] ans;
	static int V, E;
	static List<Node>[] adjList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 테케
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 정점과 간선 정보
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점
			E = Integer.parseInt(st.nextToken()); // 간선

			// 정점과 연결된 간선 정보를 입력하기 위해 인접리스트를 생성하자
			adjList = new ArrayList[V + 1];
			for (int i = 0; i < V + 1; i++)
				adjList[i] = new ArrayList<>();

			// 간선 길이만큼 정점에 대한 정보가 들어온다! 양방향 그래프임!
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				adjList[s].add(new Node(e, d));
				adjList[e].add(new Node(s, d));
			}
			
			// 친구 0번이 가는 경우와 친구 1번이 가는 경우를 각각 구해서, 더하고, 그 더한 배열에서 최소의 값을 찾아서 ans로 정해야겠지?
			ans = new int[V + 1];

			// 친구 정보가 들어와
			int F = Integer.parseInt(br.readLine());
//			int[] fr = new int[F];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < F; i++) {
				int fr = Integer.parseInt(st.nextToken());
				dijkstra(fr);
			}

			// 다 갔다 왔으니까 여기서 최솟값을 찾자
//			System.out.println(Arrays.toString(ans));
			int min = Integer.MAX_VALUE;
			int minIdx = -1;
			for (int i = 1; i <= V; i++) {
				if(min > ans[i]) {
					min = ans[i];
					minIdx = i;
				}
			}
			System.out.println(minIdx);
		}

	}

	// 다익스트라는 최단 경로 알고리즘
	// 거리 배열이 필요해
	static int[] dist;
	static boolean[] visited;

	private static void dijkstra(int st) {
		// 여러 번 들어올 거니까 여기서 초기화를 시켜놓고 사용해야겠지?
		dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		visited = new boolean[V + 1];

		// 제일 처음 인식되는 정점이 시작으로 들어온 정점이었으면 하니까 이 아이의 거리 값을 0으로 세팅하자
		dist[st] = 0;

		for (int i = 0; i < V; i++) { // 정점 개수만큼 반복을 돌면서
			// dist 배열에서 최솟값을 찾자 그게 우리의 목표니까
			int minIdx = -1;
			int minDist = Integer.MAX_VALUE;
			for (int j = 1; j <= V; j++) {
				// 방문한적이 없는 애들의 최소 거리만 찾아야 한다!
				if (!visited[j] && minDist > dist[j]) {
					minDist = dist[j];
					minIdx = j;
				}
			}
			// 찾았으니까 그리로 가자
			visited[minIdx] = true;

			// 이제 여기서 얘랑 연결 되어 있는 애들 중에 또 거리가 최솟값인 애가 새로 나올 수 있으니까 갱신을 해보자
			for (Node node : adjList[minIdx]) {
				if (!visited[node.ed] && dist[node.ed] > dist[minIdx] + node.dist) {
					dist[node.ed] = dist[minIdx] + node.dist;
				}
			}
		} // 각 정점까지의 최소 거리를 다 구했네

		// 그럼 이제 ans 배열에 옮길까?
		for (int i = 1; i <= V; i++) {
			ans[i] += dist[i];
		}
	}
}
