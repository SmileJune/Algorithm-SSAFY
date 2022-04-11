package com.ssafy.yun.pro;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {
	public static void main(String[] args) {
		int[] numbers = { 6, 10, 2 };
		System.out.println(solution(numbers));
	}

	static public String solution(int[] numbers) {
		String[] numbersStringArr = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			numbersStringArr[i] = "" + numbers[i];
		}

		Arrays.sort(numbersStringArr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
		String answer = "";
		for (int i = 0; i < numbersStringArr.length; i++) {
			answer += numbersStringArr[i];
		}

		if (numbersStringArr[0].equals("0")) {
			return "0";
		}

		return answer;

	}
}
