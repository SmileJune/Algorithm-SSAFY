package com.ssafy.yun;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1983 {

	static Scanner sc = new Scanner(System.in);
	static int N;
	static int K;

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %s%n", tc, solution());
		}
	}

	static String solution() {
		N = sc.nextInt();
		K = sc.nextInt();

		double[] arr = new double[N + 1];
		for (int i = 1; i < arr.length; i++) {
			int midScore = sc.nextInt();
			int finalScore = sc.nextInt();
			int homework = sc.nextInt();
			arr[i] = midScore * 0.35 + finalScore * 0.45 + homework * 0.2;
		}

		double KScore = arr[K];

//		Arrays.sort(arr, new Comparator<Double>() {
//			@Override
//			public int compare(Double o1, Double o2) {
//				return (int) (o2 - o1);
//			}
//		});
		// double 내림차순 정렬 어떻게 했더라....?
		Arrays.sort(arr);
		for (int i = 0; i <= arr.length / 2; i++) {
			double temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
		int pivot = -1;
		for (int i = 1; i <= 10; i++) {
			int idx = N / 10 * i;
			if (KScore >= arr[idx-1]) {
				pivot = i;
				break;
			}
		}

		switch (pivot) {
		case 1:
			return "A+";
		case 2:
			return "A0";
		case 3:
			return "A-";
		case 4:
			return "B+";
		case 5:
			return "B0";
		case 6:
			return "B-";
		case 7:
			return "C+";
		case 8:
			return "C0";
		case 9:
			return "C-";
		default:
			return "D0";
		}
	}

}
