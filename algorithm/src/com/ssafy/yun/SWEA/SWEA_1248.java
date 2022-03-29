package com.ssafy.yun.SWEA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1248 {

	static class Node {
		int upper;
		int left;
		int right;
	}

	static Node[] arr;
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException, FileNotFoundException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			arr = new Node[V + 1];

			for (int i = 1; i <= V; i++) {
				arr[i] = new Node();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= E; i++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				arr[child].upper = parent;

				if (arr[parent].left == 0) {
					arr[parent].left = child;
				} else {
					arr[parent].right = child;
				}

			}

			int pivot = 0;

			List<Integer> list = new ArrayList<>();
			while (true) {
				list.add(arr[first].upper);
				first = arr[first].upper;
				if (first == 1)
					break;
			}

			while (true) {
				if (list.contains(arr[second].upper)) {
					pivot = arr[second].upper;
					break;
				}
				second = arr[second].upper;
			}

			System.out.printf("#%d %d %d\n", tc, pivot, count(pivot));
		}

	}

	static int count(int node) {
		if (arr[node].left == 0 && arr[node].right == 0)
			return 1;

		int cnt = 1;
		if (arr[node].left != 0) {
			cnt += count(arr[node].left);
		}
		if (arr[node].right != 0) {
			cnt += count(arr[node].right);
		}

		return cnt;
	}
}