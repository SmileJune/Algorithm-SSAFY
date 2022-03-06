package com.ssafy.yun.Baek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Baek_11656 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String str = sc.nextLine();

		List<String> list = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			list.add(str.substring(i));
		}

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
