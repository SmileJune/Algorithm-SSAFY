package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day123BOJ13537수열과쿼리1자력xSegmentTree공부 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = stoi(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = stoi(st.nextToken());

		SegmentTree segmentTree = new SegmentTree(arr);

		int M = stoi(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			sb.append(segmentTree.query(1, 0, N - 1, stoi(st.nextToken()) - 1, stoi(st.nextToken()) - 1,
					stoi(st.nextToken())));
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static class SegmentTree {
		int[][] tree;

		public SegmentTree(int[] array) {
			tree = new int[array.length * 4][];
			init(array, 1);
		}

		private int[] init(int[] array, int node) {
			if (array.length == 1)
				return tree[node] = array;

			int mid = array.length + 1 >> 1;

			return tree[node] = merge(init(Arrays.copyOfRange(array, 0, mid), node * 2),
					init(Arrays.copyOfRange(array, mid, array.length), node * 2 + 1));
		}

		private int[] merge(int[] left, int[] right) {
			int[] output = new int[left.length + right.length];
			int i = 0;
			int j = 0;

			while (i < left.length || j < right.length) {
				if (i >= left.length) {
					output[i + j] = right[j++];
					continue;
				}
				if (j >= right.length) {
					output[i + j] = left[i++];
					continue;
				}

				if (left[i] >= right[j])
					output[i + j] = right[j++];
				else
					output[i + j] = left[i++];
			}
			return output;
		}

		public int query(int node, int nodeLow, int nodeHigh, int low, int high, int k) {
			if (nodeLow > high || nodeHigh < low)
				return 0;

			int nodeMid = (nodeLow + nodeHigh) >> 1;

			if (nodeLow >= low && nodeHigh <= high) {
				int l = 0;
				int h = tree[node].length - 1;
				if (tree[node][h] <= k) {
					return 0;
				}
				while (l < h) {
					int m = (l + h) >> 1;
					if (tree[node][m] <= k)
						l = m + 1;
					else
						h = m;
				}
				return tree[node].length - h;
			}

			return query(node * 2, nodeLow, nodeMid, low, high, k)
					+ query(node * 2 + 1, nodeMid + 1, nodeHigh, low, high, k);
		}
	}
}