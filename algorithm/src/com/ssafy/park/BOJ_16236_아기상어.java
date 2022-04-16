package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
	public static int N, time, sx, sy, size, count, map[][];
	public static ArrayList<Info> fishes;
	public static int dx[] = { -1, 1, 0, 0 };
	public static int dy[] = { 0, 0, -1, 1 };

	static class Info {
		int x, y, dist;

		public Info(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	public static boolean isRange(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= N;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		size = 2;

		for (int i = 0; i < N; i++) {
			String input1[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(input1[j]);
				map[i][j] = num;
				if (num == 9) {
					sx = i;
					sy = j;
					map[i][j] = 0;
				}
			}
		}

		while (true) {
			fishes = new ArrayList<Info>();
			Queue<Info> q = new LinkedList<Info>();
			boolean visited[][] = new boolean[N][N];
			q.offer(new Info(sx, sy, 0));
			visited[sx][sy] = true;

			while (!q.isEmpty()) {
				Info shark = q.poll();

				for (int d = 0; d < 4; d++) {
					int nx = shark.x + dx[d];
					int ny = shark.y + dy[d];

					if (isRange(nx, ny))
						continue;
					if (visited[nx][ny])
						continue;

					if (1 <= map[nx][ny] && map[nx][ny] < size) {
						q.offer(new Info(nx, ny, shark.dist + 1));
						fishes.add(new Info(nx, ny, shark.dist + 1));
						visited[nx][ny] = true;
					}

					else if (map[nx][ny] == size || map[nx][ny] == 0) {
						q.offer(new Info(nx, ny, shark.dist + 1));
						visited[nx][ny] = true;
					}
				}
			}

			if (fishes.size() == 0) {
				System.out.println(time);
				return;
			}

			Info eatingFish = fishes.get(0);
			for (int i = 1; i < fishes.size(); i++) {
				if (fishes.get(i).dist < eatingFish.dist) {
					eatingFish = fishes.get(i);
				}

				if (eatingFish.dist == fishes.get(i).dist) {
					if (eatingFish.x > fishes.get(i).x) {
						eatingFish = fishes.get(i);
					}
				}
			}

			time += eatingFish.dist;
			count++;
			map[eatingFish.x][eatingFish.y] = 0;

			if (count == size) {
				size++;
				count = 0;
			}

			sx = eatingFish.x;
			sy = eatingFish.y;
		}
	}
}
