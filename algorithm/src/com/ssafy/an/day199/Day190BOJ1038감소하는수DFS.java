package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day190BOJ1038감소하는수DFS { // 1038감소하는 수
	static List<Long> numList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		numList = new ArrayList<>();

		for (long i = 0; i < 10; i++) {
			numList.add(i);

			if (i > 0)
				dfs(i);
		}

		Collections.sort(numList);

		if (N >= 1023)
			System.out.println(-1);
		else
			System.out.println(numList.get(N));

	}

	public static void dfs(long num) {
		long last = num % 10;

		for (long i = last - 1; i >= 0; i--) {
			numList.add(num * 10 + i);

			if (last > 0)
				dfs(num * 10 + i);
		}
	}
}
