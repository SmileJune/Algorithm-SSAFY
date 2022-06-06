package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day0606_ICOTE_DFS_BFS_Q015 {
	static int n, m, k, x;
	static int[] d; // 정답에 활용할 배열
	static ArrayList<ArrayList<Integer>> city = new ArrayList<>();

	// 인접 행렬로 먼저 풀어보기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		d = new int[n + 1];

		// 그래프랑 d 배열 초기화
		for (int i = 0; i <= n; i++) {
			city.add(new ArrayList<>());
			d[i] = -1;
		}

		// 입력 받아야지
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			city.get(a).add(b);
		}

		d[x] = 0; // 출발하는 도시 -> 출발하는 도시의 거리 = 0

		bfs(x);
		// System.out.println(Arrays.toString(d));

		// k조건을 만족하는 게 있다면 출력하고
		boolean flag = false;
		for (int i = 0; i < d.length; i++) {
			if (d[i] == k) {
				flag = true;
				System.out.println(i);
			}
		}
		// k조건을 만족하는 게 없었다면
		if (!flag) {
			System.out.println(-1);
		}

	}

	private static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);

		while (!q.isEmpty()) {
			int curr = q.poll();

			// 현재도시에서 갈 수 있는 곳을 찾아서 그 값에 +1을 해주자
			for (int i = 0; i < city.get(curr).size(); i++) {
				int next = city.get(curr).get(i);
				// 방문 안한 곳에만
				if (d[next] == -1) {
					d[next] = d[curr] + 1;
					q.add(next);
				}
			}
		}

	}

}