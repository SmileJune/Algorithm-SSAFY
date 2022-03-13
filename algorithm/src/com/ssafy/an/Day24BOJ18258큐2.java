package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Day24BOJ18258큐2 { // 18258 큐 2
	static int N;
	static Deque<Integer> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String str = st.nextToken();

			if (st.hasMoreTokens()) {
				push(Integer.parseInt(st.nextToken()));
				continue;
			} else if (str.equals("pop")) {
				sb.append(pop());
			} else if (str.equals("size")) {
				sb.append(size());
			} else if (str.equals("empty")) {
				sb.append(empty());
			} else if (str.equals("front")) {
				sb.append(front());
			} else if (str.equals("back")) {
				sb.append(back());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void push(int i) {
		q.add(i);
	}

	public static int pop() {
		if (q.isEmpty())
			return -1;
		return q.pop();
	}

	public static int size() {
		if (q.isEmpty())
			return 0;
		return q.size();
	}

	public static int empty() {
		if (q.isEmpty())
			return 1;
		return 0;
	}

	public static int front() {
		if (q.isEmpty())
			return -1;
		return q.getFirst();
	}

	public static int back() {
		if (q.isEmpty())
			return -1;
		return q.getLast();
	}
}
