package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2075_N번쨰큰수 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringTokenizer st;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				int num = Integer.parseInt(st.nextToken());
				if(pq.size() == N) {
					if(pq.peek() < num ) {
						pq.poll();
						pq.add(num);
					}
				}else {
					pq.add(num);
				}
			}
		}
		
	}
}
