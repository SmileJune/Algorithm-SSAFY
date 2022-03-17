package com.ssafy.yun.Baek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Baek_1977 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int M = sc.nextInt();
		int N = sc.nextInt();

		List<Integer> list = new ArrayList<>();
		for (int i = (int) Math.sqrt(M); Math.pow(i, 2) <= N; i++) {
			int pow = (int) Math.pow(i, 2);
			if (M <= pow && pow <= N) {
				list.add(pow);
			}
		}

		if (list.isEmpty()) {
			System.out.println(-1);
			return;
		}

		Collections.sort(list);
		int sum = 0;
		for (Integer i : list) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println(list.get(0));
	}

}
