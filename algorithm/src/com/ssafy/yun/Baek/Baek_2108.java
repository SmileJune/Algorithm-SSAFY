package com.ssafy.yun.Baek;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baek_2108 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();
		int[] arr = new int[8001];

		// 산술평균
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			int num = sc.nextInt();
			arr[num + 4000]++;
			sum += num;
		}
		System.out.println(Math.round(sum / (double) N));

		// 중앙값
		int pivot = (N + 1) / 2;
		int cntSum = 0;
		for (int i = 0; i < arr.length; i++) {
			cntSum += arr[i];
			if (cntSum >= pivot) {
				System.out.println(i - 4000);
				break;
			}
		}

		// 최빈값
		List<Integer> list = new ArrayList<>();
		int freq = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == freq) {
				list.add(i - 4000);
				continue;
			}
			if (arr[i] > freq) {
				list = new ArrayList<>();
				list.add(i - 4000);
				freq = arr[i];
				continue;
			}
		}
		if (list.size() >= 2) {
			System.out.println(list.get(1));
		} else {
			System.out.println(list.get(0));
		}

		// 범위
		int low = 8000;
		int high = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				low = i - 4000;
				break;
			}
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] != 0) {
				high = i - 4000;
				break;
			}
		}
		System.out.println(high - low);
	}

}
