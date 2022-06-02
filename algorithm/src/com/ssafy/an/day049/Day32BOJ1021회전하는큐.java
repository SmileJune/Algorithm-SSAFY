package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Day32BOJ1021회전하는큐 { // 1021 회전하는 큐
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		LinkedList<Integer> dq = new LinkedList<>();
		for (int n = 1; n <= N; n++) {
			dq.offer(n);
		}
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int ans = 0;
		for (int m = 0; m < M; m++) {
			int n = Integer.parseInt(st.nextToken());
			int s = dq.size();
			int idx = dq.indexOf(n);
			int mid = s % 2 == 0 ? s / 2 - 1 : s / 2;
			if (idx <= mid) {
				for (int i = 0; i < idx; i++) {
					dq.offerLast(dq.pollFirst());
					ans++;
				}
			} else {
				for (int i = 0; i < s - idx; i++) {
					dq.offerFirst(dq.pollLast());
					ans++;
				}
			}
			dq.pollFirst();
		}

		System.out.println(ans);
		br.close();
	}
}
