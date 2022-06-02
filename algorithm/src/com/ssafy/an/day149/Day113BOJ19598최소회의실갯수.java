package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day113BOJ19598최소회의실갯수 { // 19598 최소회의실 갯수, 고민시간이 2시간이 되서 구선생님 도움받았습니다.  
	static class Room { int t, c; Room(int t, boolean c) { this.t = t; this.c = c ? 1 : -1; }}
	static int N, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		ans = 0;
		PriorityQueue<Room> pq = new PriorityQueue<>((o1, o2) -> (o1.t - o2.t));
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			pq.offer(new Room(u, true));
			pq.offer(new Room(v, false));
		}
		int tmp = 0;
		while (!pq.isEmpty()) {
			Room r = pq.poll();
			tmp += r.c;
			ans = Math.max(ans, tmp);
		}
		System.out.println(ans);
		br.close();
	}
}
