package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day52BOJ1956운동 {
	// 테케 88%실패여서, 구선생님 도움받음. 
	// 플로이드 값 구할때 2개 값 더하는게 있는데, 최대값으로 하면 초과되버림.
	// 최소값 활용하는 식이라 답도 아닌 것 때문에 실패 뜸. 1e9로 충분히 큰값 사용. 	
	static final int INF = (int) 1e9;
	static int V, E, min = Integer.MAX_VALUE;
	static int[][] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		dist = new int[V + 1][V + 1];
		for (int i = 0; i < V + 1; i++) {
			for (int j = 0; j < V + 1; j++) {
				dist[i][j] = INF;
			}
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int tIdx = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			dist[idx][tIdx] = Math.min(dist[idx][tIdx], d);
		}

		System.out.println(floyd());
		br.close();
	}

	private static int floyd() {
		for (int k = 1; k < V + 1; k++) {
			for (int i = 1; i < V + 1; i++) {
				for (int j = 1; j < V + 1; j++) {
					dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
				}
			}
		}
		for (int i = 1; i < V + 1; i++) {
			min = Math.min(dist[i][i], min);
		}
		return min >= INF ? -1 : min;
	}
}
