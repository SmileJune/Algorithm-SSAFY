package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1644_소수의연속합 {
	static int ans = 0;
	static int N;
	static boolean[] prime;
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		prime = new boolean[N + 1];
		list = new ArrayList<Integer>();
		prime[0] = prime[1] = true;
		for (int i = 2; i * i <= N; ++i) {
			if (prime[i]) {
				continue;
			}
			for (int j = i * i; j <= N; j += i) {
				prime[j] = true;
			}
		}
		for (int i = 1; i <= N; ++i) {
			if (!prime[i]) {
				list.add(i);
			}
		}
		int start = 0, end = 0, sum = 0;
		while (true) {
			if (sum >= N)
				sum -= list.get(start++);
			else if (end == list.size())
				break;
			else
				sum += list.get(end++);
			if (N == sum)
				ans++;
		}
		System.out.println(ans);

	}

}