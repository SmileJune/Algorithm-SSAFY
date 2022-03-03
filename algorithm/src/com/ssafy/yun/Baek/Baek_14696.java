package com.ssafy.yun.Baek;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Baek_14696 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		outer: for (int tc = 1; tc <= T; tc++) {
			int len1 = sc.nextInt();
			Integer[] arrA = new Integer[len1];
			for (int i = 0; i < len1; i++) {
				arrA[i] = sc.nextInt();
			}
			int len2 = sc.nextInt();
			Integer[] arrB = new Integer[len2];
			for (int i = 0; i < len2; i++) {
				arrB[i] = sc.nextInt();
			}

			Arrays.sort(arrA, Collections.reverseOrder());
			Arrays.sort(arrB, Collections.reverseOrder());
			int minLength = Math.min(arrA.length, arrB.length);
			for (int i = 0; i < minLength; i++) {
				if (arrA[i] == arrB[i]) {
					continue;
				}
				if (arrA[i] > arrB[i]) {
					System.out.println("A");
					continue outer;
				}
				if (arrA[i] < arrB[i]) {
					System.out.println("B");
					continue outer;
				}
			}

			if (arrA.length == arrB.length) {
				System.out.println("D");
				continue outer;
			}
			if (arrA.length > arrB.length) {
				System.out.println("A");
				continue outer;
			}
			if (arrA.length < arrB.length) {
				System.out.println("B");
				continue outer;
			}
		}

	}

}
