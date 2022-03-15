package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Day36_BOJ_B5_15740 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		BigInteger a = new BigInteger(input[0]);
		BigInteger ans = a.add(new BigInteger(input[1]));
		System.out.println(ans);
		
	}
}
