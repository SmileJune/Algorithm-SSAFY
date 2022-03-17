package com.ssafy.namja;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_14235_박성현 {
	static int n;
	static int[] heap = new int[5000 * 100 + 1];
	// 우선순위 큐로 푸는 문제
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) { 
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if (a > 0) { 
				for (int j = 0; j < a; j++)
					push(Integer.parseInt(st.nextToken()));
			} else if (a == 0) {
				System.out.println(delete());
			}
		}
		// 리스트로 풀이 (시간 초과)
		/*
		 * ArrayList<Integer> list = new ArrayList<>(); int n =
		 * Integer.parseInt(br.readLine()); for (int i = 0; i < n; i++) { String line =
		 * br.readLine(); st = new StringTokenizer(line); int a =
		 * Integer.parseInt(st.nextToken()); if (a > 0) { for (int j = 0; j < a; j++)
		 * list.add(Integer.parseInt(st.nextToken())); } else if (a == 0) { if
		 * (list.isEmpty()) bw.write(-1 + "\n"); else { bw.write(list.get(0) + "\n");
		 * list.remove(0); } } list.sort(Comparator.reverseOrder()); } bw.flush();
		 */
	}

	static void push(int item) {
		int i = 0;
		i = ++n;

		while ((i != 1) && item > heap[i / 2]) {
			heap[i] = heap[i / 2];
			i = i / 2;
		}
		heap[i] = item;
	}

	static int delete() {
		if (n == 0)
			return -1;
		
		int first, temp, parent, child;
		first = heap[1];
		temp = heap[n--];
		parent = 1;
		child = 2;

		while (child <= n) {
			if ((child < n) && (heap[child] < heap[child + 1]))
				child++;

			if (temp >= heap[child])
				break;

			heap[parent] = heap[child];
			parent = child;
			child *= 2;
		}

		heap[parent] = temp;
		return first;
	}
}
