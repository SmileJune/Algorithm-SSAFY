package com.ssafy.yun.pro;

import java.util.Arrays;

public class 카펫 {

	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;
		System.out.println(Arrays.toString(solution(brown,yellow)));
	}

	static public int[] solution(int brown, int yellow) {
		int distance = (brown - 8) / 2;
		int garo = 1 + distance;
		int sero = 1;

		for (;;) {
			if (garo * sero == yellow) {
				break;
			}

			garo -= 1;
			sero += 1;
		}
		return new int[] { garo + 2, sero + 2 };
	}

}
