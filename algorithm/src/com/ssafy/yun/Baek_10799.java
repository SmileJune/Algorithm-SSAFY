package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_10799 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int sum = 0;
		int layer = 0;
		String str = br.readLine();
		str = str.replaceAll("\\(\\)", "c");

		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case 'c':
				sum += layer;
				break;
			case '(':
				layer++;
				break;
			case ')':
				layer--;
				sum++;
				break;
			}
		}

		System.out.println(sum);
	}

}