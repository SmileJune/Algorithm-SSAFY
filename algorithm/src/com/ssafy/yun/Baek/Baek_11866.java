package com.ssafy.yun.Baek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Baek_11866 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		List<Integer> list = new ArrayList<>();
		int cnt = 0;
		while (true) {
			if (q.isEmpty()) {
				break;
			}

			int num = q.poll();
			cnt++;

			if (cnt == K) {
				list.add(num);
				cnt = 0;
				continue;
			}

			q.offer(num);

		}

		String str = list.toString();

		System.out.println("<" + str.substring(1, str.length() - 1) + ">");

	}

}
