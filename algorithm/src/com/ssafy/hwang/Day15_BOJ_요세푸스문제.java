package com.ssafy.hwang;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BOJ 요세푸스 문제
 * 
 * 사람 수 N, 양의 정수 K(K<=N) 입력받음. <br>
 * 
 * N명이 원형으로 앉았을 때, K번째 사람을 제거한다. <br>
 * 제거되는 순서를 (N,K) - 요세푸스 순열이라 한다. <br>
 * 요세푸스 순열을 구해보자.<br>
 * 
 * input : N K
 * 
 * output : < >
 */
public class Day15_BOJ_요세푸스문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder("<");
		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		while (!queue.isEmpty()) {
			int front;
			for (int i = 0; i < K-1; i++) {
				front = queue.poll();
				queue.offer(front);
			}
			front = queue.poll();
				if (sb.length() != 1) {
					sb.append(", ");
				}
				sb.append(front);
			

		}
		sb.append(">");
		System.out.println(sb.toString());

		sc.close();
	}
}
