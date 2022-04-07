package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1952_수영장 {
	static int[] price;
	static int[] plan;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			st = new StringTokenizer(br.readLine()," ");
			price =  new int[4];
			plan = new int[12];
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			min = price[3];
			cal(0,0);
			sb.append(min + "\n");
		}
		System.out.println(sb);
	}
	public static void cal(int cnt, int k) {
		if (min < k) {
			return;
		}
		if (cnt >= 12) {
			min = Math.min(min, k);
			return;
		}
		if (plan[cnt] == 0) {
			cal(cnt + 1, k);
		}
		else {
			cal(cnt + 1, k + price[0] * plan[cnt]);
			cal(cnt + 1, k + price[1]);
			cal(cnt + 3, k + price[2]);
		}
	}
}
