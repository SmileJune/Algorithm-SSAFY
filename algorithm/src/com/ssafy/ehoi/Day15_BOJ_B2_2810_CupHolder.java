package com.ssafy.ehoi;

import java.util.Scanner;

public class Day15_BOJ_B2_2810_CupHolder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int person = sc.nextInt(); // 좌석 수 = 사람 수 (다 앉는다고 했거든)
		String seat = sc.next(); // 자리 정보 입력
		
		int holder = 1; // 컵홀더수 일단 처음에 무조건 한개 
		for (int i = 0; i < seat.length(); i++) {
			char c = seat.charAt(i); // 해당 자리 를 받아서
			if (c == 'S') { // 솔로석이라면
				holder++;
			} else if (c == 'L') { // 커플 석이라면
				holder++;
				i = i + 1;
			}
		}
		int result = Math.min(person, holder);
		
		System.out.println(result);
		
		sc.close();
	}
}
