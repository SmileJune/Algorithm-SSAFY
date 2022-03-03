package com.ssafy.yun.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1224 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static Stack<Character> stack1;
	static Stack<Integer> stack2;
	static StringBuffer sb;

	public static void main(String[] args) throws IOException {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("#%d %d%n", i, solution());
		}
	}

	public static int solution() throws IOException {
		br.readLine();
		String input = br.readLine();
		sb = new StringBuffer();
		stack1 = new Stack<>();
		stack2 = new Stack<>();

		// stack1을 이용해서 후위표기법으로 바꾸자!
		for (int i = 0; i < input.length(); i++) {
			check(input.charAt(i));
		}

		while (!stack1.isEmpty()) {
			sb.append(stack1.pop());
		}

		for (int i = 0; i < sb.length(); i++) {
			check2(sb.charAt(i));
		}

		return stack2.pop();
	}

	public static void check(char ch) {
		if ('0' <= ch && ch <= '9') {
			sb.append(ch);
		}

		if (ch == '+' || ch == '-') {
			if (stack1.isEmpty()) {
				stack1.push(ch);
				return;
			}
			if (stack1.peek() == '(') {
				stack1.push(ch);
			} else {
				while (!stack1.isEmpty()) {
					if (stack1.peek() == '(') {
						break;
					}
					sb.append(stack1.pop());
				}
				stack1.push(ch);
			}
		}

		if (ch == '*' || ch == '/') {
			if (stack1.isEmpty()) {
				stack1.push(ch);
				return;
			}
			char c = stack1.peek();
			if (c != '*' && c != '/') {
				stack1.push(ch);
			} else {
				while (!stack1.isEmpty()) {
					if (stack1.peek() == '(' || stack1.peek() == '+' || stack1.peek() == '-') {
						break;
					}
					sb.append(stack1.pop());
				}
				stack1.push(ch);
			}
		}

		if (ch == '(') {
			stack1.push(ch);
		}

		if (ch == ')') {
			while (stack1.peek() != '(') {
				sb.append(stack1.pop());
			}
			stack1.pop();
		}
	}

	static void check2(char ch) {
		if ('0' <= ch && ch <= '9') {
			stack2.push(ch - '0');
			return;
		}
		if (ch == '+') {
			int a = stack2.pop();
			int b = stack2.pop();
			stack2.push(a + b);
			return;
		}
		if (ch == '-') {
			int a = stack2.pop();
			int b = stack2.pop();
			stack2.push(b - a);
			return;
		}
		if (ch == '*') {
			int a = stack2.pop();
			int b = stack2.pop();
			stack2.push(a * b);
			return;
		}
		if (ch == '/') {
			int a = stack2.pop();
			int b = stack2.pop();
			stack2.push(b / a);
			return;
		}

	}

}
