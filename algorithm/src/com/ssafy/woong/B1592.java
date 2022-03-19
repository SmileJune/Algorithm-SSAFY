package com.ssafy.woong;

import java.util.Scanner;

public class B1592 {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int n = sc.nextInt(); // 게임 참가 인원
		int m = sc.nextInt(); // 종료조건
		int l = sc.nextInt(); // 1회 이동량 
		int pos = l + 1;
		int cnt = 0; // 공 횟수
		
		int[] player = new int[n + 1];
		player[pos]++;
		while(true) {
			
			for(int num : player) {
				if(num == m) {
					System.out.println(cnt);
					return;
				}
			}
			
			if(player[pos] % 2 == 1) {
				pos += l;
				pos = (pos >= n + 1) ? pos - n : pos;
				player[pos]++;
			}
			else {
				pos -= l;
				pos = (pos < 1) ? pos + n : pos;
				player[pos]++;
			}
			cnt++;
			
			
		}
		
		
	}

}

