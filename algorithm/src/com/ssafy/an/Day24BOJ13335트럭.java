package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day24BOJ13335트럭 { // 13335 트럭
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		Queue<Integer> trucks = new LinkedList<>();
		for (int n = 0; n < N; n++) {
			trucks.offer(Integer.parseInt(st.nextToken()));
		}
		
		Queue<Integer> bridge = new LinkedList<>();
		for (int w = 0; w < W; w++) {
			bridge.add(0);
		}
		
		int cnt = 0;
		int tmp = 0;
		
		while (!bridge.isEmpty()) {
			tmp -= bridge.poll();
			if (!trucks.isEmpty()) {
				if (tmp + trucks.peek() <= L) {
					int newTruck = trucks.poll();
					tmp += newTruck;
					bridge.add(newTruck);
				} else {
					bridge.add(0);
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
