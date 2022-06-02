package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day07BOJ11004Fail2K번째수 { // 11004 다른 사람 답안
	public static void main(String[] ar) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		System.out.print(quickSearch(arr, 0, n - 1, k - 1));
	}

	public static int quickSearch(int[] arr, int start, int end, int k) {
		int pivot = partition(arr, start, end);
		if (pivot == k)
			return arr[pivot];
		else if (pivot > k)
			return quickSearch(arr, start, pivot - 1, k);
		else
			return quickSearch(arr, pivot + 1, end, k);
	}

	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i = start - 1;
		for (int j = start; j <= end; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		i++;
		swap(arr, i, end);

		return i;
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}