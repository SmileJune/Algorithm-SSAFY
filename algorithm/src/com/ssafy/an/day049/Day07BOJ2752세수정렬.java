package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day07BOJ2752세수정렬 { // 2752 세수정렬
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[3];
		arr[0] = Integer.parseInt(st.nextToken());
		arr[1] = Integer.parseInt(st.nextToken());
		arr[2] = Integer.parseInt(st.nextToken());

		if (arr[0] > arr[1]) {
			int temp = arr[0];
			arr[0] = arr[1];
			arr[1] = temp;
		}
		if (arr[1] > arr[2]) {
			int temp = arr[1];
			arr[1] = arr[2];
			arr[2] = temp;
		}
		if (arr[0] > arr[1]) {
			int temp = arr[0];
			arr[0] = arr[1];
			arr[1] = temp;
		}
		System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
	}
}
