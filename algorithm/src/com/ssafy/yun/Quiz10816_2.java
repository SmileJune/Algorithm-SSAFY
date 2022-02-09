package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Quiz10816_2 {  //upper, lower bound 더 공부하고 다시 풀어보자.

	public static int[] myArr;
	public static int[] yourArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int myArrLength = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		myArr = new int[myArrLength];
		for (int i = 0; i < myArr.length; i++) {
			myArr[i] = Integer.parseInt(st.nextToken());
		}

		int yourArrLength = Integer.parseInt(br.readLine());

		yourArr = new int[yourArrLength];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < yourArr.length; i++) {
			yourArr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(myArr);

		int[] answerArr = new int[yourArr.length];

		for (int i = 0; i < yourArr.length; i++) {

			answerArr[i] = upperbound(yourArr[i]) - lowerbound(yourArr[i]) + 1;
		}

		for (int i = 0; i < answerArr.length; i++) {
			System.out.print(answerArr[i] + " ");
		}
	}

	public static int upperbound(int target) {
		int left = 0;
		int right = myArr.length;
		int mid;
		while (left < right) {
			mid = (left + right) / 2;
			if (myArr[mid] > target) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}

		return right;
	}

	public static int lowerbound(int target) {
		int left = 0;
		int right = myArr.length;
		int mid;
		while (left < right) {
			mid = (left + right) / 2;
			if (myArr[mid] >= target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}
}