package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day63_BOJ_G4_1976 {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); // 도시의 수
		int M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시들의 수

		p = new int[N];
		for(int i = 0; i < N; i++) {
			p[i] = i;
		}
		
		
		// 일단 도시를 모두 순회하면서 인접한 도시라면 대표를 전부 한 대표로 바꿔서 같은 무리임을 표시해줄 필요가 있어보임
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1) {
					union(i, j);
				}
			}
		}

		
		// 모든 도시가 다 인접해있을 필요는 없다
		// 가려고 하는 도시들만 모두 인접해 있으면 된다.
		// 내가 가려고 하는 도시의 대표가 나의 대표와 같은지 판단하면 된다
		
		// 이제 내가 가려고 하는 도시 배열을 순회하면서 첫번째 아이와 나머지의 대표가 다 같은지 보면 되지 않을까?
		String ans = "YES";
		st = new StringTokenizer(br.readLine());
		int first = findSet(Integer.parseInt(st.nextToken())-1);
		for (int i = 1; i < M; i++) {
			int now = Integer.parseInt(st.nextToken())-1;
			if (first != findSet(now)) ans = "NO";
		}

		
		System.out.println(ans);

	}
	
	private static void union(int x, int y) {
		p[findSet(x)] = findSet(y);
	}
	
	private static int findSet(int x) {
		return p[x] = p[x] == x ? x : findSet(p[x]);
	}
}
