package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_5430_AC {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int t = 1; t <= T; ++t) {
			char[] order = br.readLine().toCharArray();
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			Deque<Integer> d = new LinkedList<>();
			st = new StringTokenizer(br.readLine(), "[],");
			for (int i = 0; i < n; ++i) {
				d.add(Integer.parseInt(st.nextToken()));
			}
			boolean flag = false;
			int k = 0;
			boolean dir = true;
			while (k < order.length) {
				switch (order[k]) {
				case 'R':
					dir = !dir;
					break;
				case 'D':
					if (d.isEmpty()) {
						flag = true;
					} else {
						if (dir)
							d.pollFirst();
						else
							d.pollLast();
					}
					break;
				}
				if (flag)
					break;
				k++;
			}
			if (flag) {
				sb.append("error");
			} else {
				sb.append('[');
				while (!d.isEmpty()) {
					if(dir) sb.append(d.pollFirst());
					else sb.append(d.pollLast());
					if(!d.isEmpty()) sb.append(",");
				}
				sb.append(']');
			}
			System.out.println(sb);
		}
	}
}