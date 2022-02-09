package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Quiz최대수구하기 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testNum = Integer.parseInt(br.readLine());
		for (int i = 1; i <= testNum; i++) {
			System.out.printf("#%d %d%n", i, solution());
		}

	}

	public static int solution() throws IOException {
		arr = new int[10];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		return arr[arr.length - 1];
	}

}
