package com.ssafy.ehoi;

import java.util.Scanner;

public class Day15_BOJ_B1_2851 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10]; // 버섯 배열
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = sc.nextInt();
//		} // 버섯 점수 입력
		// 이걸 없애고
		int score = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt(); // 여기서 입력받으면서 동시에 
			score += arr[i]; // 버섯 점수 추가!
			if (score >= 100) { // 타겟을 넘어섰어
				// 그러면 내 점수랑 직전 점수랑 비교해봐야지
//				int myGap = score - 100; // 내 점수와 100점과의 차이
//				int preGap = 100 - (score - arr[i]); // 직전 점수와 100점과의 차이
				// 이것도 생략해서 아래처럼 바꿀 수 있고
				score = score - 100 <= 100 - (score - arr[i]) ? score : score - arr[i];
				break; // break를 꼭 해줘야해..!!!!!
			}

		}
		System.out.println(score);

		sc.close();
	}
}
