package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13335_트럭 {
	static int N, W, L;
	static Queue<Integer> Bridge = new LinkedList<>();
	static Queue<Integer> Truck = new LinkedList<>();
	static boolean[] visited;
	static int bridgeSum;
	static int time;

	public static void main(String[] args) throws IOException {
		input();
		moveTruck();

		// 트럭 이동
		System.out.println(time);
	}

	private static void moveTruck() {
		time = 0;
		bridgeSum = 0;
		while (!Bridge.isEmpty()) {
			time++;
			bridgeSum -= Bridge.remove();
			if (!Truck.isEmpty()) {
				if (Truck.peek() + bridgeSum <= L) {
					bridgeSum += Truck.peek();
					Bridge.offer(Truck.poll());
				} else {
					Bridge.offer(0);
				}
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 다리를 건너는 트럭의 수
		W = Integer.parseInt(st.nextToken()); // 다리의 길이
		L = Integer.parseInt(st.nextToken()); // 다리의 최대 하중
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			Truck.add(Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < W; ++i) {
			Bridge.add(0);
		}
		// 출력은 모든 트럭이 다리를 건너는 최단기간.
		// 트럭 순서 못바꾸고 트럭의 무게는 같지 않을 수 있음. 다리위는 단지 w대의 트럭만 동시에 올라갈 수 있음.
	}
}
