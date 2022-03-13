package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Day25BOJ15828라우터 { // 15828
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		// 0 - 처리, -1 - 끝, 나머지 - 패킷번호
		int num = 0;
		while (num != -1) { // 끝
			num = Integer.parseInt(br.readLine());
			if (num == 0) // 처리
				q.poll();
			else {
				if (num > 0 && q.size() < N) // 나머지
					q.offer(num);
			}
		}

		if (q.isEmpty())
			System.out.println("empty");
		else
			while (!q.isEmpty()) {
				System.out.print(q.poll() + " ");
			}

		br.close();
	}
}
