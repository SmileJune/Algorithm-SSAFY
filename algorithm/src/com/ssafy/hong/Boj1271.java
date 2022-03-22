package com.ssafy.hong;
import java.math.BigInteger;
import java.util.*;

public class Boj1271{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		BigInteger N = sc.nextBigInteger();
		BigInteger K = sc.nextBigInteger();
		
		System.out.println(N.divide(K));
		System.out.println(N.remainder(K));
	}
}
