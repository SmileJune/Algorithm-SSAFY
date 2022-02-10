package com.ssafy.yun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Beakjoon_1158 {

	public static boolean[] visited;
	public static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int order = sc.nextInt();

		visited = new boolean[len + 1];
		visited[0] = true;

		int idx = 0;
		int cnt = 0;

		while (true) {
			int nextIdx = ++idx % (len + 1);
			if (!visited[nextIdx]) {
				cnt++;
			}
			if (cnt == order) {
				list.add(nextIdx);
				visited[nextIdx] = true;
				cnt = 0;
			}

			if (list.size() == len) {
				break;
			}
		}

		Integer[] ansArr = list.toArray(new Integer[list.size()]);
		String str = Arrays.toString(ansArr);
		String ans = "<" + str.substring(1, str.length() - 1) + ">";
		System.out.println(ans);

	}

}
