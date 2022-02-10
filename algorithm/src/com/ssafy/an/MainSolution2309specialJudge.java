package com.ssafy.an;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainSolution2309specialJudge {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		;
		int[] arr = new int[9];
		for (int i = 0; i < 9; i++)
			arr[i] = Integer.parseInt(br.readLine());
		// 거꾸로 해봅시다.
		int sum9 = 0;
		for (int i = 0; i < 9; i++) {
			sum9 += arr[i];
		}
		bubbleSort(arr);
		int num = sum9 - 100;

		int idx1 = 0;
		int idx2 = 0;

		outer: for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (arr[i] + arr[j] == num) {
					idx1 = i;
					idx2 = j;
					break outer;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			if (i != idx1 && i != idx2)
				System.out.println(arr[i]);
		}
		br.close();
	}

	private static void bubbleSort(int[] arr) {
		for (int i = 8; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

	}
}
