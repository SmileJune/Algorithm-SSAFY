package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Day37_BOJ_G5_10827 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		BigDecimal a = new BigDecimal(str[0]);
		int b = Integer.parseInt(str[1]);
		BigDecimal ans = new BigDecimal(1);
		for (int i = 0; i < b; i++) {
			ans = ans.multiply(a);
		}
		// 아 지수형태로 나와서 그런 거구나 
		System.out.println(ans.toPlainString());
		
	}
}
