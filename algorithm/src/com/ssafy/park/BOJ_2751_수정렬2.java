package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2751_수정렬2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] count = new int[1000001];
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] sortarr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			count[arr[i]]++;
		}
		for (int i =1; i<count.length; i++) {
			count[i] += count[i-1];
		}
		for (int i = 0; i< N; i++) {
			sortarr[count[arr[i]]-1] = arr[i];
			count[arr[i]]--;
		}
		for (int i : sortarr) {
			System.out.println(i);
		}

	}
}

