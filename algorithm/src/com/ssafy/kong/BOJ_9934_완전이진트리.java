package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9934_완전이진트리 {
	static int[] arr;
	static List<Integer>[] ans;
	static int[] dep;
	static int idx = 0;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int len = (int) Math.pow(2, N) - 1;
		arr = new int[len];
		ans = new ArrayList[N];
		for (int i = 0; i < N; ++i) {
			ans[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < len; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		find(0, 0, len - 1);
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < ans[i].size(); ++j) {
				sb.append(ans[i].get(j)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void find(int dep, int start, int end) {
		if (start > end) {
			return;
		}
		int mid = (start + end) / 2;
		ans[dep].add(arr[mid]);
		find(dep + 1, start, mid - 1);
		find(dep + 1, mid + 1, end);

	}

}