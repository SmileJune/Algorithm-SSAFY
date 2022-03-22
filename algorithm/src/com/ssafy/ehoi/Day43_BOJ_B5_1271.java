package com.ssafy.ehoi;

import java.math.BigInteger;
import java.util.Scanner;

public class Day43_BOJ_B5_1271 {
	public static void main(String[] args) {
		// 몫과 나머지를 구하는 문제이다.
		Scanner sc = new Scanner(System.in);
		BigInteger n = sc.nextBigInteger();
		BigInteger m = sc.nextBigInteger();
		
		
		System.out.println(n.divide(m));
		System.out.println(n.remainder(m));
		
		
		sc.close();
	}
}
