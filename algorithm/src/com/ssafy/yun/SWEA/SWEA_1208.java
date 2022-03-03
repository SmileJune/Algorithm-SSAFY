package com.ssafy.yun.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1208 {  // 이 풀이법은 이분탐색을 이용한 upper bound, lower bound 개념과 함께하면 더 강력해질 것 입니다.
	// 아직 잘 활용을 못해서 그만 ^^.....

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		for (int tc = 1; tc <= 10; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}

	}

	public static int solution() throws IOException {
		int totalDump = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		arr = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// check 0 or 1
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		double average = sum / arr.length;

		int dump = 0;
		int pivot = (int) Math.round(average);
		for (int i = 0; i < arr.length; i++) {
			int dis1 = arr[i] - pivot;
			if (dis1 > 0) {
				dump += dis1;
			}
		}

		if (dump <= totalDump) {
			if ((average - (int) average) == 0) {
				return 0;
			} else {
				return 1;
			}
		}

		
		// check others
		int high = 0;
		int low = 0;

		Arrays.sort(arr);
		int max = arr[arr.length - 1];
		int min = arr[0];

		for (int i = max; i >= 0; i--) {
			if (checkHigh(i) > totalDump) {
				high = i + 1;
				break;
			}
		}

		for (int i = min; i < max; i++) {
			int canLow = checkLow(i);
			if (canLow > totalDump) {
				low = i - 1;
				break;
			} else if (canLow == totalDump) {
				low = i;
				break;
			}

		}

		return (high - low);
	}

	public static int checkHigh(int pivot) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			int dis = arr[i] - pivot;
			if (dis > 0) {
				sum += dis;
			}
		}
		return sum;
	}

	public static int checkLow(int pivot) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			int dis = pivot - arr[i];
			if (dis > 0) {
				sum += dis;
			}
		}
		return sum;
	}

}
