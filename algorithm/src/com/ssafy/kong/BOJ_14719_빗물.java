package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {
	static int[][] map;
	static int H, W;
	static int[] height;
	static int ans;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		height = new int[W];
		visited = new boolean[W];
		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < W; ++j) {
			height[j] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < height[j]; ++i) {
				map[i][j] = 1;
			}
		}
		for (int i = 0; i < H; ++i) {
			System.out.println(Arrays.toString(map[i]));
		}

		for (int i = 0; i < H; ++i) {
			int tmp = 0;
			boolean flag = false;
			for (int j = 0; j < W; ++j) {
				if (map[i][j] == 1) {
					flag = true;
					ans += tmp;
					tmp = 0;
					continue;
				}
				if (flag)
					tmp++;
			}
		}

		System.out.println(ans);
	}

}
