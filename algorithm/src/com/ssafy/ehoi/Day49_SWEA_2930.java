package com.ssafy.ehoi;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Day49_SWEA_2930 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		outer: for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc + " ");
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
						sb.append(heap.poll() + " "); // 그거 하나 뽑아
					} else { // 없다면
						sb.append(-1).append("\n"); // -1을 출력하고 더 돌 필요 없이
						continue outer; // 다음 테케로 ㄱㄱ
					}
					break;
				}

			} 
			
		} // 테케 끝
		System.out.println(sb);
		sc.close();
	}
}
