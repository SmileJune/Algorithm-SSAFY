package com.ssafy.yun.pro;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
	public static Set<Integer> set = new HashSet<>();
	public static String[] stringArr;
	public static boolean[] visited;
	public static int ans = 0;

	public static void main(String[] args) {
		System.out.println(solution("17"));
	}

	public static int solution(String numbers) {
		stringArr = numbers.split("");
		visited = new boolean[stringArr.length];

		appendNumber(0, "");

		for (Integer integer : set) {
			if (isPrimeNumber(integer)) {
				ans++;
			}
		}

		return ans;
	}

	public static void appendNumber(int cnt, String str) {
		if (cnt > stringArr.length) {
			return;
		}
		if (!str.equals("")) {
			set.add(Integer.parseInt(str));
		}

		for (int i = 0; i < stringArr.length; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				appendNumber(cnt + 1, str + stringArr[i]);
				visited[i] = false;
			}
		}
		return;
	}

	public static boolean isPrimeNumber(Integer integer) {
		if (integer < 2)
			return false;
		for (int i = 2; i < integer; i++) {
			if (integer % i == 0) {
				return false;
			}
		}
		return true;
	}
}
