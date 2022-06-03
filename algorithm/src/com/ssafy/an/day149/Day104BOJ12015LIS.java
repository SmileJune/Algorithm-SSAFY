package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Day104BOJ12015LIS {
	static int N;
	static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		list.add(0);
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n > list.get(list.size() - 1)) list.add(n);
			else {
				int l = 0, r = list.size() - 1;
				while (l < r) {
					int m = (l + r) / 2;
					if (list.get(m) < n) l = m + 1;
					else r = m;
				}
				list.set(r, n);
			}
		}
		System.out.println(list.size() - 1);
		br.close();
	}
}
