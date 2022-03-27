package com.ssafy.yun.Baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_4344 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			solution();
		}

	}

	static void solution() throws IOException {
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		double sum = 0;
		double avg = 0;

		int[] arr = new int[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}

		avg = sum / num;
		int upper = 0;
		int lower = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > avg) {
				upper++;
			} else {
				lower++;
			}
		}

		System.out.printf("%.3f",(double)upper/num*100);
		System.out.println("%");

	}

}
