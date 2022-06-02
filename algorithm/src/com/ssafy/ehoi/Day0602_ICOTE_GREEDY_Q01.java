package com.ssafy.ehoi;

import java.util.Arrays;
import java.util.Scanner;

public class Day0602_ICOTE_GREEDY_Q01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);

		int cnt = 0;
		int ans = 0;
		for (int i = 0; i < N; i++) {
			// 모험가 모집합니다.
			cnt++;
			if(cnt >= arr[i]) { // 결성된 모험가 수로 갈 수 있을까요? 공포도보다 큰가요?
				ans++; // 그룹 결성 완료!
				cnt = 0; // 모험가 리셋
			} 
			// 필요없습니다..
//			else {
//				cnt++; // 안된다면 모험가 추가 모집!
//			}
		}
		
		System.out.println(ans);

		sc.close();
	}
}
