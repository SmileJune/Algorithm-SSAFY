package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1493_박정현 {
	static int cnt;
	static int start;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int no = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= no; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append("#" + tc + " " + test(cal(a), cal(b))).append("\n");
		}
		System.out.println(sb);
	}

	public static int[] cal(int n) {
		cnt = 0;
		start = 1;
		int idx = 1;
		while (start <= n) {
			start += idx;
			idx++;
			cnt++;
		}
		int x = 1;
		int y = cnt;
		for (int i = 0; i < n - start + idx - 1; i++) {
			x++;
			y--;
		}
		int[] arr = { x, y };
		return arr;
	}

	public static int test(int[] a, int[] b) {
		int[] arr = new int[2];
		arr[0] = a[0] + b[0];
		arr[1] = a[1] + b[1];
		int sum = 1;
		for (int i = 1; i < arr[1] + arr[0] -1; i++) {
			sum += i;
		}
		return sum + arr[0] - 1;
	}
}
