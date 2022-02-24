package com.ssafy.an;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day16BOJ1158요세푸스문제 { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		int N = sc.nextInt();
		int K = sc.nextInt();
		sb.append("<");

		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		int k = K;
		while (!q.isEmpty()) {
			k--;
			if (k != 0) {
				q.add(q.poll());
			} else if (q.size() != 1) {
				sb.append(q.poll()).append(", ");
				k = K;
			} else  // 마지막에는 ','를 붙히면 안되서, 1되면 탈출
				break;

		}
		sb.append(q.poll()).append(">");
		System.out.println(sb);
		sc.close();
	}
}
