package com.ssafy.an;

import java.util.Scanner;
import java.util.Stack;

public class Day15BOJ1874스택수열 { // 1874
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int N = sc.nextInt();
		
		int s = 0;
		boolean flag = true;
		
		while (N-- > 0) {
			int num = sc.nextInt();

			if (num > s) {
				for (int i = s + 1; i <= num; i++) {
					stack.push(i);
					sb.append('+').append("\n");
				}
				s = num;
			} else if (stack.peek() != num) {
				flag = false;
			}
			stack.pop();
			sb.append('-').append("\n");
		}
		
		if (flag)
			System.out.println(sb);
		else
			System.out.println("NO");
		sc.close();
	}
}
