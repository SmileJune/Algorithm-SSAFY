package www.ssafy.SWEA_sup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2383_점심식사시간 {
	static class Stair {
		int r;
		int c;
		int k;

		public Stair(int r, int c, int k) {
			this.r = r;
			this.c = c;
			this.k = k;
		}
	}

	static class Person {
		int r;
		int c;
		int arriveTime;
		int stairTime;
		int stair;

		public Person(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public void findArriveTime() {
			this.arriveTime = Math.abs(r - stairs[this.stair].r) + Math.abs(c - stairs[stair].c);
		}
	}

	static int N;
	static int[][] map;
	static int ans = Integer.MAX_VALUE;
	static List<Person> people;
	static boolean[] visited;
	static Stair[] stairs;
	static Queue<Person>[] ps;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; ++t) {
			ans = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			stairs = new Stair[2];
			people = new ArrayList<>();
			ps = new LinkedList[2];
			ps[0] = new LinkedList<>();
			ps[1] = new LinkedList<>();
			// 1번계단에 있는 사람, 2번 계단에 있는 사람
			int idx = 0;
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] >= 2) {
						stairs[idx++] = new Stair(i, j, map[i][j]);
					}
					if (map[i][j] == 1) {
						people.add(new Person(i, j));
					}
				}
			}
			recur(0);
			System.out.println(ans);
		} // tc
	}// main

	static void recur(int idx) {
		if (idx == people.size()) {
			visited = new boolean[people.size()];

			int cur = findTime();

			ans = ans > cur ? cur : ans;
			return;
		}

		// 첫번째 계단 이용하기
		people.get(idx).stair = 0;
		people.get(idx).findArriveTime();
		recur(idx + 1);

		// 두번째 계단 이용하기
		people.get(idx).stair = 1;
		people.get(idx).findArriveTime();
		recur(idx + 1);
	}

	private static int findTime() {
		int cnt = 0;
		int time = 1;

		while (true) {
			for (Queue<Person> q : ps) {

				for (int i = 0; i < q.size(); ++i) {
					Person p = q.poll();

					if (p.stairTime + stairs[p.stair].k <= time) {
						continue;
					}

					q.offer(p);
				}
			}

			if (cnt == people.size() && ps[0].isEmpty() && ps[1].isEmpty()) {
				return time;
			}

			for (int i = 0; i < people.size(); ++i) {
				if (visited[i])
					continue;
				Person p = people.get(i);

				if (p.arriveTime + 1 <= time && ps[p.stair].size() < 3) {
					p.stairTime = time;
					visited[i] = true;
					ps[p.stair].offer(p);
					cnt++;
				}
			}
			time++;
		}
	}

}
