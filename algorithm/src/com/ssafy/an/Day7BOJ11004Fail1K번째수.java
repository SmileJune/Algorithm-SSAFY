package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day7BOJ11004Fail1K번째수 { // 11004 pivot sort
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());

		}
		quickSort(arr, 0, N - 1, K);
		System.out.println(arr[K - 1]);
	}

	private static void quickSort(int[] arr, int left, int right, int length) {
		if (left >= right)
			return;

		int pi = partition(arr, left, right);

		if (pi + 1 == length)
			return;
		else if (pi + 1 < length)
			quickSort(arr, pi + 1, right, length);
		else 
			quickSort(arr, left, pi - 1, length);
	}

	private static int partition(int[] arr, int left, int right) {
		int mid = (left + right) / 2;
		swap(arr, left, mid);

		int pivot = arr[left];
		int i = left, j = right;

		while (i < j) {
			while (pivot < arr[j]) {
				j--;
			}

			while (i < j && pivot >= arr[i]) {
				i++;
			}
			swap(arr, i, j);
		}
		arr[left] = arr[i];
		arr[i] = pivot;
		return i;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
