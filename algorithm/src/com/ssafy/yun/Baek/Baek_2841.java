package com.ssafy.yun.Baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_2841 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;

	static Stack<Integer>[] stack = new Stack[7];
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < stack.length; i++) {
			stack[i] = new Stack<>();
		}

		for (int i = 0; i < N; i++) {
			solution();
		}

		System.out.println(sum);

	}

	static void solution() throws IOException {
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int flat = Integer.parseInt(st.nextToken());

		if (stack[row].empty()) {
			stack[row].push(flat);
			sum++;
			return;
		}

		if (stack[row].peek() == flat) {
			return;
		}

		if (stack[row].peek() < flat) {
			stack[row].push(flat);
			sum++;
			return;
		}

		while (!stack[row].empty() && stack[row].peek() > flat) {
			stack[row].pop();
			sum++;
		}

		if (stack[row].empty() || stack[row].peek() < flat) {
			stack[row].push(flat);
			sum++;
		}
		return;
	}
}
