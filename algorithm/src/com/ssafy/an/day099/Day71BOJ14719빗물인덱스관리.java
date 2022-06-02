package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day71BOJ14719빗물인덱스관리 {
	static int H, W, r, l, ans;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		ans = 0;

		arr = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i < W - 1; i++) {
			r = l = 0;
			for (int j = 0; j < i; j++)
				l = Math.max(arr[j], l);
			for (int j = i + 1; j < W; j++)
				r = Math.max(arr[j], r);
			if (arr[i] < l && arr[i] < r)
				ans += Math.min(l, r) - arr[i];
		}

		System.out.println(ans);
		br.close();
	}
}
