package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Day79BOJ17966그래프와순회모든간선 { // 17966 Graph and Cycles
	static final int INF = Integer.MAX_VALUE;
	static int N, M;
	static List<Integer>[] arr;
	static long ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		ans = 0;
		M = N * (N - 1) / 2; // 완전 그래프임을 의미함.
		arr = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++)
			arr[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) { // 간선 갯수 기준으로 노드별 list를 받는다.
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[u].add(w);
			arr[v].add(w);
		}

		// 모든 간선을 지나는(노드 중복으로 들어와도 됨)
		// 홀수 개의 노드라도 정해져있기 때문에 무조건 한붓그리기 가능
		// 완전 그래프임도 보장되기 때문에, 한 노드로부터 진행되는 간선은 짝수
		// 각 노드별로 총 개수-1개 만큼 간선을 갖는다.
		// 무방향이기 때문에 입력 받을 때, 시점, 끝점 배열에 가중치 추가
		// f(e1, e2) 는 간선간의 가중치 최대값을 반환한다. << 다만,   
		
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(arr[i]); // bestSol
			for (int j = 1; j < N; j += 2) { // 중복선택 회피
				ans += arr[i].get(j);
			} // N개(홀수)의 노드는 가 있으면, 각 노드는 N-1개 노드(짝수)를 갖는다.
		}  
		print(arr);

		System.out.println(ans);
		br.close();
	}

	private static void print(List<Integer>[] a) {
		StringBuilder tt = new StringBuilder();
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr[i].size(); j++) {
				tt.append(arr[i].get(j)).append(" ");
			}
			tt.append("\n");
		}
		System.out.println(tt);
	}

}
