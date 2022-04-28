package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Day80BOJ1715카드정렬PQ {
	static int N;
	static long ans, tmp;
	static PriorityQueue<Long> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = 0;
		pq = new PriorityQueue<>();
		// 그리디적인 생각으로는 오름차순으로 정렬하고,
		// 작은 수 끼리 더한다.
		// 다만, 더해서 만들어진 값이 또 다시 작은수라고 보장할 수 없다.
		// ex) 40, 41, 45, 79, 82 -> (81), 45, 79, 82
		// 두 개를 합치고 매번 정렬하면 시간이 과도하게 사용된다.
		// Priority Queue에 계속 넣어서 합치는 방법
		// 값만 나오면 되니, int[] arr도 필요 없을 듯
		// N도 재활용 안해도 될듯.
		while (N-- > 0)
			pq.add(Long.parseLong(br.readLine()));

		while (pq.size() > 1) { // 두개를 뽑아서 하나로 합친다. 2개이상이다.
			ans += tmp = pq.poll() + pq.poll(); // 비교횟수 증가
			pq.add(tmp); // 현재 합쳐진 값 큐에 추가
		}
		
		System.out.println(ans); // 1개 남으면 탈출할테니
		br.close();
	}
}
