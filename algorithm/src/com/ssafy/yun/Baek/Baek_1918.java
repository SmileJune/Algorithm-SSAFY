package com.ssafy.yun.Baek;

import java.util.Scanner;
import java.util.Stack;

public class Baek_1918 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String str = sc.nextLine();
		StringBuffer sb = new StringBuffer();
		Stack<Character> stack = new Stack<>();
		outer: for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			// 대문자
			if ('A' <= ch && ch <= 'Z') {
				sb.append(ch);
				continue;
			}

			if (ch == '(') {
				stack.push(ch);
				continue;
			}

			if (ch == ')') {
				while (true) {
					char c = stack.pop();
					if (c == '(') {
						break;
					}
					sb.append(c);
				}
			}

			if (ch == '+' || ch == '-') {
				while (true) {
					// 비었을때
					if (stack.empty()) {
						stack.push(ch);
						continue outer;
					}

					// 뭔가있을때
					char c = stack.peek();

					if (c == '(') {
						stack.push(ch);
						continue outer;
					}

					sb.append(stack.pop());
				}
			}

			if (ch == '*' || ch == '/') {
				while (true) {
					// 비었을 때
					if (stack.empty()) {
						stack.push(ch);
						continue outer;
					}

					char c = stack.peek();

					if (c == '(') {
						stack.push(ch);
						continue outer;
					}

					if (c == '+' || c == '-') {
						stack.push(ch);
						continue outer;
					}

					sb.append(stack.pop());
				}
			}

		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb.toString());
	}

}
