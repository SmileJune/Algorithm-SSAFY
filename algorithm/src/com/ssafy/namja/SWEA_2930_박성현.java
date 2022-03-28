package com.ssafy.namja;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_2930_박성현 {
	static PriorityQueue<Integer> heap;
//	static int n;
//	static int[] heap;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
//			heap = new int[1000000];
			heap = new PriorityQueue<Integer>(Collections.reverseOrder());

			System.out.printf("#%d ", t);
			int n = sc.nextInt(); // 수행해야 하는 연산 수
			for (int i = 0; i < n; i++) {
				int op = sc.nextInt();
				if (op == 1) {
					heap.add(sc.nextInt());
					continue;
				} else {
					if (heap.isEmpty())
						System.out.print(-1 + " ");
					else
						System.out.print(heap.poll() + " ");
				}
			}
			System.out.println();
		}
	}

	/*static void add(int item) {
		int i = ++n;

		while (i != 1 && item >= heap[i / 2]) {
			heap[i] = heap[i / 2];
			i /= 2;
		}
		heap[i] = item;
	}

	static int poll() {
		if (n == 0)
			return -1;
		int first, temp, parent, child;
		first = heap[1];
		temp = n--;
		parent = 1;
		child = 2;

		while (child <= n) {
			if ((child < n) && (heap[child] <= heap[child + 1]))
				child = child + 1;

			heap[parent] = heap[child];
			parent = child;
			child *= 2;
		}
		heap[parent] = heap[temp];
		return first;
	}*/

}