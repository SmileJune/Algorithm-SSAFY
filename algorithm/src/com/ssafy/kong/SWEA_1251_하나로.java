package day0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SWEA_1251_하나로 {
	static class Dot implements Comparable<Dot> {
		int r, c;
		long w;

		public Dot(int r, int c, long w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Dot o) {
			// TODO Auto-generated method stub
			return Long.compare(this.w, o.w);

		}

	}

	static int N;
	static Dot[] island;
	static int[] p;
	static List<Dot>[] adjList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			N = Integer.parseInt(br.readLine());
			island = new Dot[N];
			adjList = new ArrayList[N];
			for (int i = 0; i < N; ++i) {
				adjList[i] = new ArrayList<>();
			}
			String[] x = br.readLine().split(" ");
			String[] y = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				island[i] = new Dot(Integer.parseInt(x[i]), Integer.parseInt(y[i]), 0);
			}
			double E = Double.parseDouble(br.readLine());
			int idx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					long w = (long) (island[i].r - island[j].r) * (island[i].r - island[j].r)
							+ (long) (island[i].c - island[j].c) * (island[i].c - island[j].c);
					adjList[i].add(new Dot(i, j, w));
					adjList[i].add(new Dot(j, i, w));
				}
			}
			boolean[] visited = new boolean[N];
			visited[0] = true;
			PriorityQueue<Dot> pq = new PriorityQueue<>();

			pq.addAll(adjList[0]);
			int cnt = 1;
			long ans = 0;

			while (cnt != N) {
				Dot edge = pq.poll();
				if (visited[edge.c])
					continue;
				ans += edge.w;
				pq.addAll(adjList[edge.c]);
				visited[edge.c] = true;
				cnt++;
			}
			System.out.println("#" + t + " " + Math.round(E * ans));

		}
	}

}
