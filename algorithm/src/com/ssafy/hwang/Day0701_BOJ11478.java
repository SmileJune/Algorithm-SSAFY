package com.ssafy.hwang;

import java.util.*;

public class Day0701_BOJ11478 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<String> resSet = new HashSet<>();
		char[] input = sc.nextLine().toCharArray();
		String tmp = "";

		for (int i = 0; i < input.length; i++) {
			tmp = "";
			for (int j = i; j < input.length; j++) {
				tmp = tmp + input[j];
				resSet.add(tmp);
			}
		}
		System.out.println(resSet.size());
	}
}
