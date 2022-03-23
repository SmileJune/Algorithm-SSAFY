package com.ssafy.hwang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day44_BOJ_세수정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int[] arr;
		arr = new int[3];
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < 3; i++)
			arr[i] = Integer.parseInt(s[i]);

		selectionSort(arr);

		for (int i : arr)
			sb.append(i).append(" ");

		System.out.println(sb);

	}

	public static void selectionSort(int[] arr) {

		int min;

		for (int i = 0; i < arr.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min])
					min = j;
			}
			int tmp = arr[i];
			arr[i] = arr[min];
			arr[min] = tmp;

		}

	}
}
