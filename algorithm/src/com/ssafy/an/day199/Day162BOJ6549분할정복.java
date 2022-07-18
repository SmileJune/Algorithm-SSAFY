package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day162BOJ6549분할정복 { // 6549 분할정복 구
	public static int[] histogram;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N;
		while (true) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());

			if (N == 0) {
				break;
			}
			histogram = new int[N];
			for (int i = 0; i < N; i++) {
				histogram[i] = Integer.parseInt(st.nextToken());
			}
			sb.append(getArea(N)).append('\n');
			histogram = null;

		}
		System.out.println(sb);
		br.close();
	}

	public static long getArea(int len) {
		int[] stack = new int[len];
		int sSize = 0;
		int top = -1;

		long maxArea = 0;

		for (int i = 0; i < len; i++) {
			while (sSize > 0 && histogram[stack[top]] >= histogram[i]) {
				int height = histogram[stack[top--]];
				sSize--;
				long width = sSize == 0 ? i : i - 1 - stack[top];

				maxArea = Math.max(maxArea, height * width);
			}

			stack[++top] = i;
			sSize++;

		}
		while (sSize > 0) {
			int height = histogram[stack[top--]];
			sSize--;

			long width = sSize == 0 ? len : len - 1 - stack[top];
			maxArea = Math.max(maxArea, width * height);
		}

		return maxArea;

	}

}