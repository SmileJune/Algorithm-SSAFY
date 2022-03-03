package com.ssafy.yun.Baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_2477 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int numberPer = Integer.parseInt(br.readLine());
		int[] directionArr = new int[12];
		int[] lengthArr = new int[12];
		int small = 0, large = 0, garo = 0, sero = 0;

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());

			directionArr[i] = directionArr[i + 6] = direction;
			lengthArr[i] = lengthArr[i + 6] = length;
		}

		for (int i = 2; i < 6 + 2; i++) {
			if (directionArr[i] == directionArr[i - 2] && directionArr[i + 1] == directionArr[i - 1]) {
				small = lengthArr[i] * lengthArr[i - 1];
			}
		}

		for (int i = 0; i < directionArr.length; i++) {
			if (directionArr[i] == 1 || directionArr[i] == 2) {
				garo = Math.max(garo, lengthArr[i]);
			}
			if (directionArr[i] == 3 || directionArr[i] == 4) {
				sero = Math.max(sero, lengthArr[i]);
			}
		}
		large = garo * sero;

		System.out.println((large - small) * numberPer);

	}

}
