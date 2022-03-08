package com.ssafy.woong;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2751 {

	static int[] sorted;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	static void mergeSort(int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			merge(start, mid, end);
		}
	}

	static void merge(int start, int mid, int end) {
		int left = start;
		int right = mid + 1;
		int k = start;

		while (left <= mid && right <= end) {
			if (arr[left] < arr[right]) {
				sorted[k] = arr[left];
				left++;
			} else {
				sorted[k] = arr[right];
				right++;
			}
			k++;
		}

		while (left <= mid) {
			sorted[k] = arr[left];
			left++;
			k++;
		}

		while (right <= end) {
			sorted[k] = arr[right];
			right++;
			k++;
		}

		for (int i = start; i <= end; i++) {
			arr[i] = sorted[i];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		sorted = new int[num];
		arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		mergeSort(0, arr.length - 1);
		for (int i = 0; i < num; i++) {
			sb.append(arr[i] + "\n");
		}
		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
