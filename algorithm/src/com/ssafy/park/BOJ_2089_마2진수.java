package com.ssafy.park;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2089_마2진수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>();

		if (n == 0)
			System.out.println(n);

		while (n != 0) {
			list.add(Math.abs(n % -2));
			n = (int) Math.ceil((double) n / -2);
		}

		for (int i = list.size() - 1; i >= 0; i--)
			System.out.print(list.get(i));
	}
}
