package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1940_가라RC카 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(br.readLine());
			int order = 0;
			int speed = 0;
			int distance = 0;
			for (int i = 0; i < N; ++i) {
				int acc = 0;
				st = new StringTokenizer(br.readLine());
				order = Integer.parseInt(st.nextToken());
				if (order == 1)
					acc = Integer.parseInt(st.nextToken());
				if (order == 2)
					acc = Integer.parseInt(st.nextToken()) * (-1);
				speed += acc;
				if(speed < 0) speed = 0;
				distance += speed;
			}
			System.out.println("#" + t + " " + distance);
		}
	}
}