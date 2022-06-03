package com.ssafy.an.day049;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day23BOJ11866요세푸스문제0 { // 11866 요세푸스 문제 0
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int K = sc.nextInt();
		for (int n = 1; n <= N; n++) {
			q.offer(n);
		}
		int cnt = K - 1;
		sb.append("<");
		while (!q.isEmpty()) {
			if (cnt > 0) {
				q.offer(q.poll());
				cnt--;
				continue;
			}
			if (q.size() == 1)
				break;
			sb.append(q.poll()).append(", ");
			cnt = K - 1;
		}
		sb.append(q.poll() + ">");
		System.out.println(sb);
		sc.close();
	}
}
