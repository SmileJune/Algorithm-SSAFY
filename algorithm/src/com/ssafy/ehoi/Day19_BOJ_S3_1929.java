package com.ssafy.ehoi;

import java.util.Scanner;

public class Day19_BOJ_S3_1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		// 소수인 것만 출력
		for (int t = M; t <= N; t++) { // 두 자연수 사이 모두 판별
			boolean prime = true; // 소수라고 먼저 판단하고
			
			if(t==1) prime = false; // 만약 그 수가 1이라면 소수 아님
			
			for (int i = 2; i*i <= t; i++) {
				if(t % i == 0) {
					prime = false; // 그 수가 i로 나뉜다면 소수가 아님
					break; // 더 확인해볼 필요 없음
				}
			}
			
			// 소수가 아닌 친구들만 걸렀음
			
			if(prime) System.out.println(t); // 소수라면 그 수 출력해 
		}
		
		sc.close();
	}

}
