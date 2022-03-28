package com.ssafy.ehoi;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Day49_SWEA_2930_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d ", tc);
			PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

			int n = sc.nextInt();
			 for (int i = 0; i < n; i++) {
				int action = sc.nextInt();

				switch (action) {
				case 1:
					heap.add(sc.nextInt());
					break;
				case 2:
					if (!heap.isEmpty()) { // 힙에 원소가 있다면
						System.out.print(heap.poll() + " ");
					} else { // 없다면
						System.out.print(-1 + " ");
					}
					break;
				
				}
			} // 한 테케 끝 
			 System.out.println();
			
		} // 테케 끝
		sc.close();
	}
}
