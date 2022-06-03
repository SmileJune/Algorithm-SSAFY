package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Day103BOJ2699 { // 2699 격자점 컨벡스헐.. 하루를 공으로 날렸네.. 구선생님 도움이요..
	static class Pos implements Comparable<Pos> {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Pos o) {
			if (this.c == o.c)
				return Integer.compare(this.r, o.r);
			return Integer.compare(o.c, this.c);
		}
	}

	static int N;
	static Pos[] list;
	static Stack<Pos> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			list = new Pos[N];
			stack = new Stack<Pos>();
			int idx = 0;
			for (int i = 0; i < (N - 1) / 5 + 1; i++) {
				st = new StringTokenizer(br.readLine());
				while (st.hasMoreTokens()) 
					list[idx++] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				
			}

			Arrays.sort(list);
			Arrays.sort(list, 1, N, new Comparator<Pos>() {
				@Override
				public int compare(Pos o1, Pos o2) {
					int ccw = ccw(list[0], o1, o2);

					if (ccw > 0)
						return -1;
					else if (ccw < 0)
						return 1;
					else
						return Long.compare(dist(list[0], o1), dist(list[0], o2));
				}
			});
			
			stack.push(list[0]);
			stack.push(list[1]);

			for (int i = 2; i < N; i++) {
				Pos next = list[i];

				while (stack.size() >= 2) {
					Pos second = stack.pop();
					Pos first = stack.peek();

					int ccw = ccw(first, second, next);
					if (ccw > 0) {
						stack.push(second);
						break;
					}
				}
				stack.push(next);
			}

			sb.append(stack.size()).append("\n");
			for (int i = 0; i < stack.size(); i++)
				sb.append(stack.get(i).r).append(" ").append(stack.get(i).c).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
		br.close();
	}


	public static int ccw(Pos r, Pos p, Pos q) {
		int result = (p.r - r.r) * (q.c - r.c) - (p.c - r.c) * (q.r - r.r);

		if (result > 0)
			return -1;
		else if (result == 0)
			return 0;
		else
			return 1;
	}

	public static long dist(Pos p1, Pos p2) {
		return (p2.r - p1.r) * (p2.r - p1.r) + (p2.c - p1.c) * (p2.c - p1.c);
	}

}