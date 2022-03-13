package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day15BOJ10828스택 { // 10828
	public static int[] stack;
	public static int top = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());

		stack = new int[N];
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(pop()).append('\n');
				break;
			case "size":
				sb.append(size()).append('\n');
				break;
			case "empty":
				sb.append(empty()).append('\n');
				break;
			case "top":
				sb.append(peek()).append('\n');
				break;
			}
		}
		System.out.println(sb);
		br.close();
	}

	public static void push(int item) {
		stack[top++] = item;
	}

	public static int pop() {
		if (top == -1) {
			return -1;
		}
		int res = stack[top];
		stack[top--] = 0;
		return res;
	}

	public static int size() {
		return top + 1;
	}

	public static int empty() {
		if (top == -1) {
			return 1;
		}
		return 0;
	}

	public static int peek() {
		if (top == -1) {
			return -1;
		}
		return stack[top];
	}
}