package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958_박정현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int no = Integer.parseInt(br.readLine());
		for (int n = 0; n < no; n++) {
			String str = br.readLine();
			int temp = 0;
			int sum = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'O') {
					temp++;
					sum += temp;
				} else
					temp = 0;
			}
			System.out.println(sum);
		}
	}
}
