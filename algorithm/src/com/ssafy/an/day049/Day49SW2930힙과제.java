package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day49SW2930힙과제 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			StringBuilder ans = new StringBuilder();

			int N = Integer.parseInt(br.readLine());

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());

				while (st.hasMoreTokens()) {
					int act = Integer.parseInt(st.nextToken());
					if (act == 1) {
						pq.add(Integer.parseInt(st.nextToken()));
					} else {
						if (pq.isEmpty())
							ans.append("-1").append(" ");
						else
							ans.append(pq.poll()).append(" ");
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
