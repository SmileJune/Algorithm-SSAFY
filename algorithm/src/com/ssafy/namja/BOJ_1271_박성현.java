package com.ssafy.namja;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_1271_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger n = sc.nextBigInteger();
		BigInteger m = sc.nextBigInteger();
		
		System.out.println(n.divide(m));
		System.out.println(n.remainder(m));
	}
}