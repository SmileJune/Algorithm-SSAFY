package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_2930_힙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());
			int N = Integer.parseInt(br.readLine());

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					pqueue.add(Integer.parseInt(st.nextToken()));
				} else {
					if (pqueue.isEmpty()) {
						sb.append(-1 + " ");
					} else {
						sb.append(pqueue.poll() + " ");
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
