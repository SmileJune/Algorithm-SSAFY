package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286_절대값힙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>(
				(o1, o2) -> Math.abs(o1) - Math.abs(o2) == 0 ? o1 - o2 : Math.abs(o1) - Math.abs(o2));
		// 만약 0을 반환하게 된다면 -을 먼저 출력해야 한다?
		for (int i = 0; i < N; ++i) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (pq.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pq.poll());
				}
			} else {
				pq.offer(num);
			}
		}
	}
}
