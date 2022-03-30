package com.ssafy.namja;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1235_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		int T = sc.nextInt();
		sc.nextLine();
		for (int t = 0; t < T; t++)
			list.add(sc.nextLine());
		int length = 1;
		int endLength = list.get(0).length();
		while (length <= 100) {
			boolean flag = true;
			check : for (int i = 0; i < T - 1; i++) {
				for (int j = i + 1; j < T; j++) {
					if (list.get(i).substring(endLength - length)
							.equals(list.get(j).substring(endLength - length))) {
						flag = false;
						break check;
					}
				}
			}
			if (flag) 
				break;
			else
				length++;
		}
		System.out.println(length);
	}
}