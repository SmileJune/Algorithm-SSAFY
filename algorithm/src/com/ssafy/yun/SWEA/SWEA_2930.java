package com.ssafy.yun.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_2930 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static PriorityQueue<Integer> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d ", tc);
			solution();
			System.out.println();
		}
	}

	static void solution() throws NumberFormatException, IOException {
		int order = Integer.parseInt(br.readLine());
		q = new PriorityQueue<>(Collections.reverseOrder());
		for (int n = 1; n <= order; n++) {
			check();
		}
	}

	static void check() throws IOException {
		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());

		if (first == 2) {
			//비었을때
			if(q.isEmpty()) {
				System.out.print("-1 ");
				return;
			}
			
			//있을때
			System.out.print(q.poll()+" ");
			return;
		}
		
		//값 넣을때
		int second = Integer.parseInt(st.nextToken());
		q.add(second);
	}

}
