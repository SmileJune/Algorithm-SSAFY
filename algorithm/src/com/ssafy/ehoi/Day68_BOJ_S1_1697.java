package com.ssafy.ehoi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day68_BOJ_S1_1697 {
	static int N, K;
	static int[] time = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		if (N == K) System.out.println(0);
		else bfs(N);
		sc.close();
	}

	private static void bfs(int subin) {
		Queue<Integer> q = new LinkedList<>();
		q.add(subin); // 현재 위치를 큐에 넣고
		time[subin] = 1; // 다음 위치의 시간을 현재 위치의 인덱스에 넣어둔다

		while (!q.isEmpty()) {
			int curr = q.poll(); // 현재 위치를 꺼내서

			for (int i = 0; i < 3; i++) {
				int next = 0;
				if (i == 0) {
					next = curr - 1;
				} else if (i == 1) {
					next = curr + 1;
				} else {
					next = curr * 2;
				}

				if (next == K) {
					System.out.println(time[curr]);
					return;
				}

				// 같지 않다면 다시 큐에 들어가야지
				// 근데 큐에 들어갈 자격을 갖춰서 들어가야함
				if (next < 0 || next >= time.length)
					continue;
				if (time[next] != 0) continue; // 이미 방문했다는 뜻 + 먼저 방문한 최단 거리를 갱신하지 말자
				
				q.add(next); // 필터를 다 거친 next만 add가능
				time[next] = time[curr] + 1;// 방문처리함과 동시에 최단 거리 저장

			}

		}
	}
}

