package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baek_5430 {  // 반례 더 찾아보자....
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static List<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			try {
				solution();
			} catch (Exception e) {
				System.out.println("error");
			}
		}

	}

	public static void solution() throws IOException {
		String order = br.readLine();

		int len = Integer.parseInt(br.readLine());
		String input = br.readLine();

		String[] inputArr = input.substring(1, input.length() - 1).split(",");

		list = new ArrayList<>();
		try {
			for (int i = 0; i < inputArr.length; i++) {
				list.add(Integer.parseInt(inputArr[i]));
			}
		} catch (NumberFormatException e) {
			list = new ArrayList<>();
		}

		int pos = 1;
		for (int i = 0; i < order.length(); i++) {
			switch (order.charAt(i)) {
			case 'R':
				pos *= (-1);
				break;

			case 'D':
				if (pos == 1) {
					list.remove(0);
				} else {
					list.remove(list.size() - 1);
				}
				break;
			}
		}
		Object[] ans1 = list.toArray();
		if (pos == 1) {
			print(ans1);
		} else {
			Object[] ans2 = new Object[ans1.length];
			for (int i = 0; i < ans2.length; i++) {
				ans2[i] = ans1[ans1.length - 1 - i];
			}
			print(ans2);

		}

	}

	public static void print(Object[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				System.out.printf("%d", arr[i]);
				break;
			}
			System.out.printf("%d,", arr[i]);
		}
		System.out.println("]");
	}

}
