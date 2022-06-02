package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day23BOJ10845큐 { // 10845 큐
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Queue q = new Queue(n);

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if (cmd.equals("push")) {
				int x = Integer.parseInt(st.nextToken());
				q.push(x);
			} else if (cmd.equals("pop")) {
				sb.append(q.pop()).append("\n");
			} else if (cmd.equals("size")) {
				sb.append(q.size()).append("\n");
			} else if (cmd.equals("empty")) {
				sb.append(q.empty()).append("\n");
			} else if (cmd.equals("front")) {
				sb.append(q.front()).append("\n");
			} else if (cmd.equals("back")) {
				sb.append(q.back()).append("\n");
			}
		}
		System.out.println(sb);
	}

	static class Queue {
		private int[] arr;
		private int size = 0;
		private int front = 0;
		private int rear = 0;

		public Queue(int n) {
			arr = new int[n];
		}

		public void push(int x) {
			arr[rear++] = x;
			if (rear >= arr.length) {
				rear = 0;
			}
			size++;
		}

		public int pop() {
			if (rear == front) {
				return -1;
			}
			int data = arr[front++];

			if (front >= arr.length) {
				front = 0;
			}
			size--;
			return data;
		}

		public int size() {
			return size;
		}

		public int empty() {
			return size == 0 ? 1 : 0;
		}

		public int front() {
			if (size == 0) {
				return -1;
			}
			return arr[front];
		}

		public int back() {
			if (size == 0) {
				return -1;
			}
			if (rear == 0) {
				return arr[arr.length - 1];
			} else {
				return arr[rear - 1];
			}
		}
	}
}
