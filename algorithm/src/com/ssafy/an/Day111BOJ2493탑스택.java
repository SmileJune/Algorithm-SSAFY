package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Day111BOJ2493탑스택 { // 2493 탑 스택
	static class Tow { int n, t; Tow(int n, int t) { this.n = n; this.t = t; } }
	static int N;
	static Stack<Tow> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			int t = Integer.parseInt(st.nextToken());

			if (stack.isEmpty()) {
				sb.append(stack.size()).append(" ");
				stack.push(new Tow(i, t));
				continue;
			}
			while (true) {
				if (stack.isEmpty()) {
					sb.append(stack.size()).append(" ");
					stack.push(new Tow(i, t));
					break;
				}
				if (stack.peek().t > t) {
					sb.append(stack.peek().n).append(" ");
					stack.push(new Tow(i, t));
					break;
				} else {
					stack.pop();
				}				
			}
		}
		System.out.println(sb);
		br.close();
	}
}
