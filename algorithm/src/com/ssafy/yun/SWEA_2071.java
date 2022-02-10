package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2071 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d", tc, average());
			System.out.println();
		}

	}

	public static int average() throws IOException {
		double[] arr = new double[10];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Double.parseDouble(st.nextToken());
		}

		double sum = 0;
		for (double ele : arr) {
			sum += ele;
		}

		return round(sum / arr.length);
	}

	public static int round(double num) {

		num *= 10;
		num += 5;
		return (int) (num / 10);
	}

}
