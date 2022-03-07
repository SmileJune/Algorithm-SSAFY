package com.ssafy.yun.Baek;

import java.util.Arrays;
import java.util.Scanner;

public class Baek_1546 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();
		double[] arr = new double[N];
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		Arrays.sort(arr);

		double avg = sum / N;
		System.out.println(avg / arr[arr.length - 1] * 100);

	}

}
