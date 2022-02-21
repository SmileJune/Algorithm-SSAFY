package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon1918_후위표기식 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] charArr = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		Stack<Character> op = new Stack<>();
		for (int i = 0; i < charArr.length; ++i) {
			if (charArr[i] == '(') {
				op.push(charArr[i]);
			} else if (charArr[i] >= 'A' && charArr[i] <= 'Z') {
				sb.append(charArr[i]);
			} else if (charArr[i] == ')') {
				while (!op.isEmpty() && op.peek() != '(') {
					sb.append(op.pop());
				}
				op.pop();
			} else { // 우선순위가 낮거나 같은 연산자가 온 경우
				while (!op.isEmpty() && priority(op.peek()) <= priority(charArr[i])) {
					sb.append(op.pop());
				}
				op.push(charArr[i]);// 우선순위가 높은 연산자가 온 경우에는 넣어줌.
			}
		}
		while (!op.isEmpty()) {
			sb.append(op.pop());
		}
		System.out.println(sb);
	}

	static int priority(char op) {
		switch (op) {
		case '*':
		case '/':
			return 1;
		case '-':
		case '+':
			return 2;
		case '(':
			return 5;
		}
		return -1;

	}
}