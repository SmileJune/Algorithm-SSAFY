package com.ssafy.yun.pro;

import java.util.Arrays;

public class 자연수를뒤집어배열로만들기 {
	public static int[] solution(long n) {
		String str = String.valueOf(n);
		String[] arr = new String[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.substring(i, i + 1);
		}

		String[] new_arr = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			new_arr[i] = arr[arr.length - 1 - i];
		}

		int[] answer = new int[new_arr.length];
		for (int i = 0; i < new_arr.length; i++) {
			answer[i] = Integer.parseInt(new_arr[i]);
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(12345)));
	}
}
