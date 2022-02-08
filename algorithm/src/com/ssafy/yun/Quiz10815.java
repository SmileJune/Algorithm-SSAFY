package com.ssafy.yun;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz10815 {

	public static int[] myArr;
	public static int[] yourArr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int myNum = sc.nextInt();
		myArr = new int[myNum];
		for (int i = 0; i < myArr.length; i++) {
			myArr[i] = sc.nextInt();
		}
		int yourNum = sc.nextInt();
		yourArr = new int[yourNum];
		for (int i = 0; i < yourArr.length; i++) {
			yourArr[i] = sc.nextInt();
		}

		Arrays.sort(myArr);

		int[] answerArr = new int[yourNum];

		for (int i = 0; i < yourArr.length; i++) {
			answerArr[i] = check(yourArr[i]);
		}

		for (int i = 0; i < answerArr.length; i++) {
			System.out.print(answerArr[i] + " ");
		}

	}

	public static int check(int target) {
		int left = 0;
		int right = myArr.length - 1;

		while (left < right) {
			if (myArr[left] == target)
				return 1;

			if (myArr[right] == target)
				return 1;
			int mid = (left + right) / 2;

			if (myArr[mid] == target) {
				return 1;
			}
			if (myArr[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}
		return 0;
	}

}
