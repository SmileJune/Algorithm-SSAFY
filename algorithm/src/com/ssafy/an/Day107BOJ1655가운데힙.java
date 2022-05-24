package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Day107BOJ1655가운데힙 { // 1655 가운데 힙
	static int N;
	static PriorityQueue<Integer> min, max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		min = new PriorityQueue<>((o1, o2) -> o1 - o2);
		max = new PriorityQueue<>((o1, o2) -> o2 - o1);

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (min.size() == max.size())
				max.offer(num);
			else
				min.offer(num);

			if (!min.isEmpty() && !max.isEmpty())
				if (min.peek() < max.peek()) {
					int tmp = min.poll();
					min.offer(max.poll());
					max.offer(tmp);
				}

			sb.append(max.peek() + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}
