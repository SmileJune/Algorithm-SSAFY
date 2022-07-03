package com.ssafy.hwang;

import java.util.*;

public class Day0703_BOJ11656 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		String[] arr = new String[s.length()];
		for(int i =0; i<s.length();i++) {
			arr[i] = s.substring(i);
		}
		Arrays.sort(arr);
		for(int i = 0 ; i <arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
