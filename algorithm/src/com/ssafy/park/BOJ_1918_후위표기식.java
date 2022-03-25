package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1918_후위표기식 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();

		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] >= 'A' && arr[i] <= 'Z')
				sb.append(arr[i] + "");
			else {
				if (arr[i] == '(')
					stack.push(arr[i]);
				else if (arr[i] == ')') {
					while (!stack.isEmpty() && stack.peek() != '(') {
						sb.append(stack.pop());
					}
					if (!stack.isEmpty())
						stack.pop();
				} else {
					while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(arr[i])) {
						sb.append(stack.pop());
					}
					stack.push(arr[i]);
				}
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}

	public static int precedence(char op) {
		if (op == '*' || op == '/')
			return 2;
		else if (op == '+' || op == '-')
			return 1;
		else
			return 0;
	}

}
