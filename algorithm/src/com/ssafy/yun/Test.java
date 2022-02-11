package com.ssafy.yun;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		String input ="[]";
		String str = input.substring(1, input.length() - 1);
		System.out.println(str);
		String[] inputArr = str.split(",");
		System.out.println(Arrays.toString(inputArr));
	}

}
