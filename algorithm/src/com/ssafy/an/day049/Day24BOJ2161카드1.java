package com.ssafy.an.day049;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day24BOJ2161카드1 { // 2161 카드1
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		int N = sc.nextInt();
		for (int n = 1; n <= N; n++) {
			q.add(n);
		}
		while (true) {
			if (q.size() == 1)
				break;
			sb.append(q.poll()).append(" ");
			q.add(q.poll());
		}
		System.out.println(sb.append(q.poll()));
		sc.close();
	}
}
