package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day114BOJ1092배PQBestSOl { // 1092 배 BestSol PriorityQueue 사용하는 best solution
	static class Crane implements Comparable<Crane> {
		int w, n;

		Crane(int weight, int cnt) {
			this.w = weight;
			this.n = cnt;
		}

		@Override
		public int compareTo(Crane o) {
			return this.n - o.n;
		}
	}

	static int N, M, ans, cidx, bidx;
	static int[] crn, box;
	static PriorityQueue<Crane> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		crn = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			crn[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(crn);

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		box = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			box[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(box);

		// sol
		if (crn[N - 1] < box[M - 1]) {
			ans = -1;
		} else {
			cidx = N - 1;
			bidx = M - 1;
			pq = new PriorityQueue<Crane>();
			adder();

			while (bidx >= 0) {
				if (cidx >= 0 && box[bidx] <= crn[cidx]) {
					adder();
				}
				counter();
				bidx--;
			}

			ans = 0;
			for (Crane c : pq)
				ans = ans < c.n ? c.n : ans;
		}
		System.out.println(ans);
		br.close();
	}

	private static void adder() {
		int weight = crn[cidx];
		for (int i = 0; i < N; i++) {
			if (crn[cidx] == weight) {
				pq.offer(new Crane(crn[cidx], 0));
				cidx--;
				if (cidx < 0)
					break;
			} else
				break;
		}
	}

	private static void counter() {
		Crane temp = pq.poll();
		temp.n += 1;
		pq.offer(temp);
	}
}