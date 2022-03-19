package com.ssafy.hwang;
/*
 *  [BOJ 14255 부분수열의 합]
 * 
 *  재귀함수 실습문제와 유사한 문제입니다.
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Day10_BOJ14225_부분수열의합 {
	static boolean[] check;
	static boolean[] result;
	static int N;
	static int[] arr;
	static int sum;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		check = new boolean[N];
		arr = new int[N];
		int total = 0;
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
		}
		Arrays.sort(arr);
		
		result = new boolean[total+1];
		powerSet(0);
		for(int i=1;i<result.length;i++) {
			if(!result[i]) { 
				System.out.println(i);
				return;
			}
		}
		System.out.println(total+1);			
		sc.close();
	}
	
	public static void powerSet(int num) {
		int idx = num;
		if(num==N) {
			sum=0;
			for(int i=0; i<N;i++) {
				if(check[i]) {
					sum += arr[i];
				}
			}
			result[sum] = true;
			return;
		}
		
		check[idx] = true; 
		powerSet(idx+1);
		check[idx] = false; 
		powerSet(idx+1);
		
	}
}
