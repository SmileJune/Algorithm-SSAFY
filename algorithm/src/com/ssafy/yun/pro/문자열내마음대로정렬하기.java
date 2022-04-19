package com.ssafy.yun.pro;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열내마음대로정렬하기 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] { "sun", "bed", "car" }, 1)));
	}

	public static String[] solution(String[] strings, int n) {
		sorting(strings, n);
		return strings;
	}

	private static void sorting(String[] strings, int n) {
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.charAt(n) == o2.charAt(n)) {
					return o1.compareTo(o2);
				}

				if (o1.charAt(n) > o2.charAt(n)) {
					return 1;
				}

				return -1;
			}
		});
	}
}
