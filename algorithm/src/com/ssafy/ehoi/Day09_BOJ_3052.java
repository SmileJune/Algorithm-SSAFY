package com.ssafy.ehoi;

import java.util.Scanner;

// 총 10개의 수가 주어지는데
// 무조건 42로 나눔
// 그러면 나머지가 0부터 41까지 총 42개가 나옴 => 배열을 생성함
// 그리고 나머지가 나올때마다 그 [나머지] 를 ++해주고
// 서로 다른 값을 봐야 하는데 [인덱스]가 0이 아닌 것만 세면 어때
public class Day09_BOJ_3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[42];
		
		for (int i =0; i < 10; i++) {
			arr[sc.nextInt()%42]++;
		}
	
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] !=0) sum++;
		}
		
		System.out.println(sum);
		
		sc.close();
	}
}
