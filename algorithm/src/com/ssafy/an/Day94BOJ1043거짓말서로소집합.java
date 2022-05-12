package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Day94BOJ1043거짓말서로소집합 { // 1043 거짓말 
	static int N, M, T, P, ans;
	static int[] p;
	static List<Integer>[] prt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사람 수
		M = Integer.parseInt(st.nextToken()); // 파티 수
		ans = M;
		p = new int[N + 1];
		prt = new ArrayList[M];

		makeSet();
		// 진실을 아는 사람 수, 번호
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수
		if (st.hasMoreTokens())
			P = Integer.parseInt(st.nextToken()); // 진실그룹 아무나 대표정하기
		while (st.hasMoreTokens())
			p[Integer.parseInt(st.nextToken())] = P;

		for (int i = 0; i < M; i++) {
			prt[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 이번 파티 참석인원
			int t = Integer.parseInt(st.nextToken());
			prt[i].add(t);
			for (int j = 1; j < n; j++) {
				int s = Integer.parseInt(st.nextToken());
				prt[i].add(s);
				unionSet(t, s);			
			}			
		}
		for (int i = 0; i < M; i++)
			if (findSet(P) == findSet(prt[i].get(0)))
				ans--;

		System.out.println(ans);
		br.close();
	}

	private static void makeSet() {
		for (int i = 0; i < N + 1; i++)
			p[i] = i;
	}

	private static int findSet(int n) {
		return p[n] = (n == p[n]) ? n : findSet(p[n]);
	}

	private static boolean unionSet(int a, int b) { // 안써도 될듯.
		if ((a = findSet(a)) == (b = findSet(b)))
			return false;
		p[b] = a;
		return true;
	}
}
