package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Quiz10816 { //기본 이분 탐색으로 인덱스 구하고 양옆으로 값 확인 하는 방법은 최악의 경우 O(n)이 될 수 있다.

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
			answerArr[i] = checkNumber(checkIndex(yourArr[i]));
		}

		for (int i = 0; i < answerArr.length; i++) {
			System.out.print(answerArr[i] + " ");
		}
	}

	public static int checkNumber(int index) {
		if (index == -1)
			return 0;

		int pivot = myArr[index];
		int num = 0;

		for (int i = index; i < myArr.length; i++) {
			if (myArr[i] != pivot)
				break;

			num++;
		}

		for (int i = index - 1; i >= 0; i--) {
			if (myArr[i] != pivot)
				break;
			num++;
		}
		return num;

	}

	public static int checkIndex(int target) {
		int left = 0;
		int right = myArr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (myArr[mid] == target)
				return mid;

			if (myArr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}
		return -1;
	}

}
