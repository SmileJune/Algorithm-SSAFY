package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day194BOJ1069집으로 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		double dis = Math.sqrt(x * x + y * y);

		int jump = (int) dis / d;

		double time;
		if (t >= d)
			time = dis;
		else if (dis > d) {
			time = Math.min((jump + 1) * t, jump * t + (dis - jump * d));
		} else if (dis == d) {
			time = Math.min(dis, t);
		} else {
			time = Math.min(dis, 2 * t);
			time = Math.min(time, ((jump + 1) * d) - dis + (jump + 1) * t);

		}
		System.out.println(time);
		br.close();
	}
}
