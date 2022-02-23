package com.ssafy.ehoi;

import java.util.Scanner;

public class Day16_BOJ_B1_2999 {
	public static void main(String[] args) {
		// 해독 과정이니까 역순으로 갈거야
		// 나는 R >= C 인 걸로 구해서
		// RC 배열에 행 우선순회로 입력받아서
		// 열 우선순회로 출력할거야
		
		// 그리고 len == 1이면 입력한 거 바로 출력해주는 것도 고려하자
		
		Scanner sc = new Scanner(System.in);
		
//		String msg = sc.nextLine();
//		int len = msg.length();
		
		char[] ch = sc.next().toCharArray(); // 받은 문자열을 문자 배열로 바꾸고
		int len = ch.length; // 그 배열의 길이를 변수에 저장하고
		
		if(len == 1) { // 혹시나 길이가 하나라면 첫번째 인덱스 출력하고
			System.out.println(ch[0]);
		}
		
		int R = 0;
		int C = 0;
		// R이 더 긴 걸 찾으려면 i가 1부터 커지는 
		for (int i = len; i >=1 ; i--) {
			if(len%i == 0 && i >= len/i) { // 배열 만드려고 배열 크기 구하는 중
				R = i;
				C = len/i;
			}
		}
		
		int idx = 0;
		char[][] msg = new char[R][C]; // 메시지 담을 배열 크기 만들고
		for(int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				msg[r][c] = ch[idx++]; // 거기다가 문자 하나하나 담고 
			}
		}
		
		for (int c = 0; c < C; c++) { // 열부터 우선순회하면서
			for (int r = 0 ; r < R; r++) {
				System.out.print(msg[r][c]); // 메시지 출력
			}
		}
		
		sc.close();
	}
}
