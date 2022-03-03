package com.ssafy.yun.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2063 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int len = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int arr[] = new int[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int temp = -1;
		int idx = -1;
		int min = 101;

		for (int i = 0; i < arr.length - 1; i++) {
			temp = arr[i];
			min = arr[i];

			for (int j = i + 1; j < arr.length; j++) {
				if (min > arr[j]) {
					min = arr[j];
					idx = j;
				}
			}

			if (idx != -1) {
				arr[i] = min;
				arr[idx] = temp;
			}

			idx = -1;

		}

		System.out.println(arr[(len - 1) / 2]);

	}

}
