package com.ssafy.ehoi;

import java.util.Scanner;

public class Day0603_ICOTE_GREEDY_Q05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 볼링공 개수
		int m = sc.nextInt(); // 볼링공 최대 무게

		int[] arr = new int[n];
		int[] cnt = new int[m+1];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt(); // 볼링공 무게 입력받기
			cnt[arr[i]]++;
		}
		
		// 볼링공 총 조합은?
		int total = n * (n-1) / 2;
		
		// 중복되는 볼링공(2개 이상)이라면 조합의 수에서 제외하자!
		for (int i = 1; i <= m; i++) {
			if(cnt[i] >= 2) {
				total--;
			}
		}
		System.out.println(total);
		
		sc.close();
	}
}