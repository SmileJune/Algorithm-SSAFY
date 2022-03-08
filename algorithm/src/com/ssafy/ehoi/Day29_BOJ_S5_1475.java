package com.ssafy.ehoi;

import java.util.Arrays;
import java.util.Scanner;

public class Day29_BOJ_S5_1475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String N = sc.next(); // 방 번호 입력 <= 1,000,000
		int[] cnt = new int[9]; // 0부터 8까지의 카운트 배열 생성 , 9는 6으로 받을 거야
		
		for (int i = 0; i < N.length(); i++) {
			int tmp = N.charAt(i) - '0';
			if (tmp == 9) { // 9라면 6이랑 같이 보게 6에다가 더해줘
				cnt[6]++;
			} else cnt[tmp]++; // 아니면 그냥 자기 자리에 더해줘
		}
// 		System.out.println(Arrays.toString(cnt));
		// 내가 놓친 부분은 cnt[6] = 8이고 cnt[5]가 7이라면 7이 출력 되어야 하는데 
		// 이런 경우에는 4가 출력 되겠지!
		// 그러니까 cnt[6] 처리를 바꾸고 최댓값을 찾으러 가야해!
		
		int tmp = cnt[6];
		cnt[6] = (tmp+1)/2;
		
		int max = 0;
		for (int i = 0; i < cnt.length; i++) {
			max = Math.max(max, cnt[i]);
		}
		
		
		System.out.println(max);
		
		sc.close();
	}
}
