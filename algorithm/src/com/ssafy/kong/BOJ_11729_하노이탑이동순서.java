package com.ssafy.BOJ_SB;

import java.util.*;
import java.io.*;

public class BOJ_11729_하노이탑이동순서 {
	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		hanoi(n, 1, 3, 2);
		System.out.println(cnt);

		System.out.print(sb.toString());
	}

	static void move(int n, int start, int to) {
		sb.append(start + " " + to + '\n');
		cnt++;
	}

	static void hanoi(int n, int start, int to, int via) {
		if (n == 1) {
			move(1, start, to);
		} else {
			hanoi(n - 1, start, via, to);
			move(n, start, to);
			hanoi(n - 1, via, to, start);
		}
	}
}