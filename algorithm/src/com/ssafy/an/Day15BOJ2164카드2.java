package com.ssafy.an;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day15BOJ2164카드2 {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int n = 1; n <= N; n++) {
			q.offer(n);
		}
		while(q.size()!=1) {
			q.poll();
			q.offer(q.poll());
		}
		System.out.println(q.poll());
		sc.close();
	}
}
