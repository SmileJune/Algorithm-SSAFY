package com.ssafy.ehoi;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Day49_BOJ_S2_1927_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			int k = sc.nextInt();
			if (k == 0) {
				if (heap.isEmpty()) {
					System.out.println(0); // 힙이 비어있으면 0을 출력 한다
				} else {
					// 그게 아니면 poll한 값을 출력한다.
					System.out.println(heap.poll());
				}
			} else { // 양수이면 집어 넣는다
				heap.add(k);
			}
		} // 끝
		
		sc.close();
	}
}
