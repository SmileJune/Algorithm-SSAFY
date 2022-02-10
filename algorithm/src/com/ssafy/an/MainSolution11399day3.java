package com.ssafy.an;

import java.util.Arrays;
import java.util.Scanner;

public class MainSolution11399day3 { // 11399 ATM
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] arr = new int[num];
		for(int i = 0 ; i < num ; i++) {
			arr[i] = sc.nextInt();
		}
		sc.nextLine();
		
		Arrays.sort(arr);
		
		int sum = 0;
		for(int i = 0 ; i < num ; i++) {
			sum += (arr[i]*(num-i)); // 가장 시간이 짧은 사람이 여러번 겹쳐져야 한다.
		}
		System.out.println(sum);
		sc.close();
	}
}
