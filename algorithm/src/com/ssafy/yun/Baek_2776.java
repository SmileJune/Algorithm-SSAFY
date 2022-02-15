package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_2776 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int[] answerArr;
	public static int[] yourArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			solution();
		}
		bw.close();
	}

	public static void solution() throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		answerArr = new int[n];
		for (int i = 0; i < answerArr.length; i++) {
			answerArr[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		yourArr = new int[m];
		for (int i = 0; i < yourArr.length; i++) {
			yourArr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(answerArr);

		for (int i = 0; i < yourArr.length; i++) {
			if (isAnswer(yourArr[i])) {
				bw.write("1\n");
			} else {
				bw.write("0\n");
			}
		}
	}

	public static boolean isAnswer(int pivot) {
		int left = 0;
		int right = answerArr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (answerArr[mid] == pivot) {
				return true;
			}

			if (answerArr[mid] > pivot) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return false;
	}

}
