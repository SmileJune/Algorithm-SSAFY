package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_1205 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int jokerCnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				jokerCnt++;
				continue;
			}
			break;
		}

		if (jokerCnt == arr.length) {
			System.out.println(jokerCnt);
			return;
		}

		int max = -1;
		for (int i = jokerCnt; i < arr.length; i++) {
			int joker = jokerCnt;
			int firstNumber = arr[i];
			int len = 1;

			while (joker != -1) {
				if (isElement(arr, ++firstNumber, i)) {
					len++;
				} else {
					len++;
					joker--;
				}
			}

			max = Math.max(max, len - 1);
		}

		System.out.println(max);

	}

	public static boolean isElement(int[] arr, int num, int firstIdx) {
		for (int i = firstIdx; i < arr.length; i++) {
			if (arr[i] == num) {
				return true;
			}
			if (arr[i] > num) {
				return false;
			}
		}
		return false;
	}

}
