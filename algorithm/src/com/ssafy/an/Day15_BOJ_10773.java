package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day15_BOJ_10773 { // 10773
	static int[] stack;
	static int top = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		stack = new int[N];
		for (int n = 0; n < N; n++) {
			int i = Integer.parseInt(br.readLine());

			if (i != 0) {
				push(i);
			} else {
				pop();
			}

		}
		int sum = 0;
		int s = top + 1;
		for (int n = 0; n < s; n++) {
			sum += pop();
		}
		System.out.println(sum);
		br.close();
	}
	// 문제에서 0의 갯수가 나머지 수 갯수보다 작음을 보장함.
	private static int pop() {
		return stack[top--];
	}

	
	private static void push(int i) {
		stack[++top] = i;
	}
}
