package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//class Document {
//	int docuNumber; // 문서의 문서번호
//	int pri; // 우선순위
//
//	public Document(int docuNumber, int pri) {
//		this.docuNumber = docuNumber;
//		this.pri = pri;
//	}
//}

public class baekjoon1966_프린터큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int t = 1; t <= T; ++t) {
			Queue<Integer> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] p = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				// {초기 위치, 중요도, 나오는 순서}
				p[i] = Integer.parseInt(st.nextToken());
				q.add(i);
			}
			int[] index = new int[n + 1];
			int idx = 0;
			outer: while (!q.isEmpty()) {
				int dNum = q.poll();
				for (int i = 1; i <= n; ++i) {
					if (p[dNum] < p[i]) {
						q.offer(dNum);
						continue outer;
					}
					if (i == n) {
						p[dNum] = 0;
						index[dNum] = ++idx;
					}
				}
			}
//			for(int i = 1; i <= n; ++i) {
//				System.out.print(index[i] + " ");
//			}
			System.out.println(index[m+1]);
		}
	}
}