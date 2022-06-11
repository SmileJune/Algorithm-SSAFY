package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Day124BOJ1927최소힙구현 {
	static int[] heap;
	static int idx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N;

		N = Integer.parseInt(br.readLine());
		heap = new int[N * 4];
		idx = 0;
		while (N-- > 0) {
			int num = Integer.parseInt(br.readLine());
			if (num > 0) {
				add(num);
			} else {
				bw.write(delete() + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static void add(int num) {
		heap[++idx] = num;
		int numIdx = idx;

		while (numIdx != 0)
			if (heap[numIdx] < heap[numIdx / 2]) {
				swap(numIdx, numIdx / 2);
				numIdx /= 2;
			} else
				break;
	}

	public static int delete() {
		if (idx == 0)
			return 0;
		int min = heap[1];
		heap[1] = heap[idx];
		heap[idx] = 0;
		int tmp = 1;
		--idx;
		while (tmp <= idx) {
			int childNode = (get(tmp * 2) > get(tmp * 2 + 1)) ? tmp * 2 + 1 : tmp * 2;
			if (heap[tmp] > get(childNode)) {
				swap(tmp, childNode);
				tmp = childNode;
			} else {
				break;
			}
		}
		return min;
	}

	public static void swap(int idx1, int idx2) {
		int tmp = heap[idx1];
		heap[idx1] = heap[idx2];
		heap[idx2] = tmp;
	}

	public static int get(int index) {
		if (index > idx)
			return Integer.MAX_VALUE;
		else
			return heap[index];
	}
}
