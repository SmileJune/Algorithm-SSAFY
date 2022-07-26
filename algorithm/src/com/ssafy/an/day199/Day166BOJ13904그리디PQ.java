package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day166BOJ13904그리디PQ { // 13904 정렬 그리디 우선순위 큐 구선생님 도움
	static int N;
	static int[][] paper;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		paper = new int[N][2];

		int day = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			paper[i][0] = Integer.parseInt(st.nextToken());
			paper[i][1] = Integer.parseInt(st.nextToken());
			day = day < paper[i][0] ? paper[i][0] : day;
		}

		Arrays.sort(paper, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return (o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
			}
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		int j = 0, answer = 0;
		for (int i = day; i > 0; i--) {
			for (; j < N && paper[j][0] >= i; j++) {
				pq.add(paper[j][1]);
			}

			if (!pq.isEmpty())
				answer += pq.poll();
		}

		System.out.println(answer);
		br.close();
	}
}
