package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Quiz_Gravity {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] lengths = new int[n];
		for (int i = 0; i < lengths.length; i++) {
			int length = lengths.length - 1 - i;
			for (int j = i+1; j < lengths.length; j++) {
				if (arr[j] >= arr[i]) {
					length--;
				}
			}
			lengths[i] = length;
		}

		Arrays.sort(lengths);

		System.out.println(lengths[lengths.length - 1]);

	}

}
