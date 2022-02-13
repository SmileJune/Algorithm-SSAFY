package com.ssafy.ehoi;

import java.util.Scanner;

public class Day06_BOJ_2577_StringVer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt() * sc.nextInt() * sc.nextInt();
		
		int[] arr = new int[10];
		
		// number의 값을 문자열로 바꿔줌 
		String input = String.valueOf(number);
		// 그 숫자의 자리수 하나하나를 돌면서
		for (int i = 0; i < input.length(); i++) {
			//i번째 자리의 문자에서 '0'을 빼준 것이 i의 자리수가 되기 때문에 
			// 그 수를 arr의 인덱스 자리에서 ++해준다
			arr[input.charAt(i)-'0']++;
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
		
		sc.close();
	}
}
