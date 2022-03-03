package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_8958 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			System.out.println(solution());
		}
	}

	public static int solution() throws IOException {
		int sum = 0;
		int score = 0;

		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'O') {
				score++;
			} else {
				score = 0;
			}
			sum += score;
		}

		return sum;

	}

}
