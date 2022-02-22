package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Day15_BOJ_9012 { // 9012
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();
		for (int n = 0; n < N; n++) {
			String ans = "YES";
			String str = br.readLine();
			stack = new Stack<>();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == '(')
					stack.add(c);
				else if (c == ')') {
					if (stack.isEmpty() || stack.pop() != '(') {
						ans = "NO";
						break;
					}
				}
			}

			if (!stack.isEmpty())
				ans = "NO";

			sb.append(ans).append("\n");
		}

		System.out.println(sb);
		br.close();
	}
}
