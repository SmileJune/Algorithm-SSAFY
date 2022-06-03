package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Day34BOJ5430AC언어데큐 { // 5430 AC 덱큐
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			char[] cmd = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());
			dq = new LinkedList<>();
			st = new StringTokenizer(br.readLine(), "[],");
			for (int n = 0; n < N; n++) {
				dq.add(Integer.parseInt(st.nextToken()));
			}

			boolean reverse = false;
			boolean error = false;
			for (int idx = 0; idx < cmd.length; idx++) {
				char c = cmd[idx];
				if (c == 'R') {
					reverse = !reverse ? true : false;
					continue;
				}
				if (dq.isEmpty()) {
					error = true;
					break;
				}

				if (reverse)
					dq.pollLast();
				else
					dq.pollFirst();
			}
			if (!error) {
				if (reverse && dq.size() > 0) {
					sb.append("[");
					while (dq.size() > 1) {
						sb.append(dq.pollLast()).append(",");
					}
					sb.append(dq.pollLast()).append("]\n");
				} else
					sb.append(dq.toString().replaceAll(" ", "")).append("\n");
			} else
				sb.append("error\n");
		}
		System.out.println(sb);
		br.close();
	}
}
