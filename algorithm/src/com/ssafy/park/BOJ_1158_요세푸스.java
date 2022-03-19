package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		sb.append("<");
		Queue<Integer> queue = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int no = Integer.parseInt(st.nextToken());
		for (int i =1; i <= no; i++) {
			queue.add(i);
		}
		int K = Integer.parseInt(st.nextToken());
		while (queue.size() != 1) {
			for (int i = 0 ; i < K-1; i++) {
				queue.add(queue.poll());
			}
			sb.append(queue.poll() + ", ");
		}
		sb.append(queue.poll() + ">");
		System.out.println(sb);
	}
}
