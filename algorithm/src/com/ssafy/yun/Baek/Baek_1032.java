package com.ssafy.yun.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_1032 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine();
		}

		StringBuffer sb = new StringBuffer();

		outer: for (int i = 0; i < arr[0].length(); i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j].charAt(i) != arr[j + 1].charAt(i)) {
					sb.append("?");
					continue outer;
				}
			}
			sb.append(arr[0].charAt(i));
		}

		System.out.println(sb);
	}

}
