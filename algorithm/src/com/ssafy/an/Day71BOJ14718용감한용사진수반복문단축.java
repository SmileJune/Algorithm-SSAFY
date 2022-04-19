package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day71BOJ14718용감한용사진수반복문단축 {
	static int N, K, ans;
	static List<int[]> list;
	static PriorityQueue<int[]> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans = 3_000_000;
		list = new LinkedList<>();
		pq = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()) });
		}
		while (!pq.isEmpty()) {
			list.add(pq.poll());
		}
		for (int l = 0; l < N; l++) {
			for (int j = 0; j < N; j++) {
				int s = list.get(l)[0], d = list.get(j)[1];
				int i = 0, c = 0;
				for (int[] a : list) {
					if (s >= a[0] && d >= a[1]) {
						i = a[2];
						c++;
					}
					if (c == K) {
						ans = Math.min(ans, s + d + i);
						break;
					}
				}
			}
		}
		System.out.println(ans);
		br.close();
	}
}
