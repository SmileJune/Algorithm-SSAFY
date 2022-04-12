package com.ssafy.yun.pro;

import java.util.Arrays;

public class HIndex {
	static int[] citationsArr;
	static int highestIndexLowerThanA = -1;

	public static void main(String[] args) {
		int[] citations = { 3, 0, 6, 1, 5 };
		System.out.println(solution(citations));
	}

	static public int solution(int[] citations) {
		citationsArr = citations;
		Arrays.sort(citationsArr);

		for (int i = citationsArr[citationsArr.length - 1]; i >= 0; i--) {
			if (check(i)) {
				return i;
			}
		}

		return 0;
	}

	static public boolean check(int a) {
		for (int i = citationsArr.length - 1; i >= 0; i--) {
			if (citationsArr[i] < a) {
				highestIndexLowerThanA = i;
				break;
			}
			if (i == 0) {
				highestIndexLowerThanA = -1;
			}
		}

		int cntMoreThanA = citationsArr.length - 1 - highestIndexLowerThanA;

		if (cntMoreThanA < a) {
			return false;
		}

		if (highestIndexLowerThanA + 1 > a) {
			return false;
		}
		return true;
	}
}
