package com.ssafy.yun.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Baek_10866 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static Deque<Integer> deque = new ArrayDeque<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			solution();
		}
	}

	public static void solution() throws IOException {
		st = new StringTokenizer(br.readLine());
		try {
			switch (st.nextToken()) {
			case "push_front":
				deque.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				deque.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				int a = deque.pollFirst();
				System.out.println(a);
				break;
			case "pop_back":
				int b = deque.pollLast();
				System.out.println(b);
				break;
			case "size":
				System.out.println(deque.size());
				break;
			case "empty":
				if (deque.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case "front":
				System.out.println(deque.getFirst());
				break;
			case "back":
				System.out.println(deque.getLast());
				break;
			}
		} catch (NoSuchElementException | NullPointerException e) {
			System.out.println(-1);
		}

	}

}
