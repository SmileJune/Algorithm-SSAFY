package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Day145BOJ14425문자열해쉬맵 {
	static int N, M, cnt;
	static HashSet<String> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0;

		set = new HashSet<>();
		for (int i = 0; i < N; i++)
			set.add(br.readLine());

		for (int i = 0; i < M; i++)
			if (set.contains(br.readLine()))
				cnt++;

		System.out.println(cnt);
		br.close();
	}
}