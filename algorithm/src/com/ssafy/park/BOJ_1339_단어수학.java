package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1339_단어수학 {
	static int N;
	static String[] arr;
	static int[] alphabet;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		alphabet = new int[26];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		for (int i = 0; i < N; i++) {
			int temp = (int) Math.pow(10, arr[i].length() - 1);
			for (int j = 0; j < arr[i].length(); j++) {
				alphabet[(int) arr[i].charAt(j) - 65] += temp;
				temp /= 10;
			}
		}

		Arrays.sort(alphabet);
		int index = 9;
		int sum = 0;
		for (int i = alphabet.length - 1; i >= 0; i--) {
			if (alphabet[i] == 0) {
				break;
			}
			sum += alphabet[i] * index;
			index--;
		}
		System.out.println(sum);
	}

}
