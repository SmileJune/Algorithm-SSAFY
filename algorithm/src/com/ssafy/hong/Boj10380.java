package com.ssafy.hong;
import java.util.*;

public class Boj10380 {
	/**
	 * [BOJ: 10380] 행렬 제곱
	 * N*N인 행렬 A의 B 제곱을 구하시오.
	 * A^B의 각 원소를 1000으로 나눈 나머지를 출력
	 * 
	 * input:	N B			행렬의 크기, B
	 * 			a00 a01..	A행렬의 원소들
	 * 			a10 a11..
	 * 			..
	 * output:	b00 b01..	A^B행렬의 원소들을 1000으로 나눈 나머지
	 * 			b10 b11..
	 * 			..
	 */
	static long[][] mat;
	static int N;
	static final int MOD = 1000;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long B = sc.nextLong();
		
		mat = new long[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)mat[i][j] = sc.nextLong()%MOD;
		}
		
		mat = multiple(B);
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)System.out.printf("%d ",mat[i][j]);
			System.out.println();
		}
	}
	
	static long[][] multiple(long n) {
		if(n == 1) {
			return mat;
		}
		
		long[][] temp = multiple(n/2);
		
		return n%2==0? calc(temp,temp): calc(calc(temp,temp), mat);
	}
	
	static long[][] calc(long[][] n, long[][] m){
		long [][] temp = new long[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				long t = 0;
				for(int k=0; k<N; k++) {
					t+=n[i][k]*m[k][j]%MOD;
					t%=MOD;
				}
				temp[i][j] = t%MOD;
			}
		}
		return temp;
	}
}
