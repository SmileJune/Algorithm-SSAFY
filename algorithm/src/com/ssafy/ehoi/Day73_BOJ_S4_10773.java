package com.ssafy.ehoi;

import java.util.Scanner;
import java.util.Stack;

// 스택
public class Day73_BOJ_S4_10773 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int tmp = sc.nextInt();
			if (tmp == 0) {
				stack.pop();
			} else {
				stack.add(tmp);
			}
		}
		int cnt = 0;
		while(!stack.isEmpty()) {
			cnt += stack.pop();
		}
		System.out.println(cnt);
		
		sc.close();
	}
}
