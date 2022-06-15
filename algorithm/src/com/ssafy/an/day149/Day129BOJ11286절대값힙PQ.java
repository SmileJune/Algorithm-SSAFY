package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Day129BOJ11286절대값힙PQ { // 11286
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if (Math.abs(o1) > Math.abs(o2))
				return Math.abs(o1) - Math.abs(o2);
			else if (Math.abs(o1) == Math.abs(o2))
				return o1 - o2;
			else
				return -1;
		}); // new Comparator<Integer>() compare함수를 오버라이드 하는게 속도가 더 좋다. 

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (pq.isEmpty())
					sb.append("0").append("\n");
				else
					sb.append(pq.poll()).append("\n");
			} else {
				pq.offer(x);
			}
		}
		System.out.println(sb);
		br.close();
	}
}
