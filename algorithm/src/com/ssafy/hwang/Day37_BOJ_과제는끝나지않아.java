package com.ssafy.hwang;

import java.util.Scanner;
import java.util.Stack;

public class Day37_BOJ_과제는끝나지않아 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int A = sc.nextInt();
			if (A == 1) {
				stack.add(sc.nextInt());
				stack.add(sc.nextInt());
			}
			else if(A == 0 && stack.empty() ) {
				continue;
			}
			int T = stack.pop();
			if (T == 1) {
				sum += stack.pop();
			} else {
				stack.add(T - 1);
			}
		}
		System.out.println(sum);
	}
}
