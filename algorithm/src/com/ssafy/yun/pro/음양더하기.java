package com.ssafy.yun.pro;

public class 음양더하기 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 4, 7, 12 }, new boolean[] { true, false, true }));
	}

	public static int solution(int[] absolutes, boolean[] signs) {

		int sum = 0;
		for (int absolute : absolutes) {
			sum += absolute;
		}

		for (int i = 0; i < signs.length; i++) {
			if (signs[i] == false) {
				sum -= (absolutes[i] * 2);
			}
		}

		int answer = sum;
		return answer;
	}
}
