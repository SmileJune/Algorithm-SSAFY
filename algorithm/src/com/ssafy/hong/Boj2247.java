package com.ssafy.hong;
import java.util.Scanner;

public class Boj2247 {
	/**
	 * [BOJ: 2247] 실질적 약수
	 * 어떤 정수의 약수 중, 1과 자기 자신을 제외한 약수들을 실질적 약수라고 한다.
	 * 실질적 약수의 합을 SOD(n)이라 정의하고, CSOD(n)=SOD(1)+SOD(2)+..+SOD(n)이라 하자.
	 * CSOD(n)을 구하라
	 * 
	 * input:	N	정수
	 * output:	ans	CSOD(n)
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int MOD=1000000;
		int ans = 0;
		for(int i=2; i<N; i++) {
			ans+=(i*((N/i)-1));
			ans%=MOD;
		}
		System.out.println(ans);
	}
}
