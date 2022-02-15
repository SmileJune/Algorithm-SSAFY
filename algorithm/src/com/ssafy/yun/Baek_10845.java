package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_10845 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<Integer> q = new LinkedList<>();

		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
			case "push":
				q.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				try {
					int a = q.poll();
					System.out.println(a);
				} catch (NullPointerException e) {
					System.out.println(-1);
				}
				break;
			case "size":
				System.out.println(q.size());
				break;
			case "empty":
				if (q.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case "front":
				try {
					int b = ((LinkedList<Integer>) q).getFirst();
					System.out.println(b);
				} catch (NoSuchElementException e) {
					System.out.println(-1);
				}
				break;
			case "back":
				try {
					int c = ((LinkedList<Integer>) q).getLast();
					System.out.println(c);
				} catch (NoSuchElementException e) {
					System.out.println(-1);
				}
				break;
			}
		}

	}

}
