package com.ssafy.ehoi;

import java.util.Scanner;

//알파벳을 입력받아서 그 사이에 있는 수를 출력하라
//알파벳의 아스키코드는 숫자로 바뀌니까 '0'과 활용하면 되지 않을까?
public class Codeup1254 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 문자열로 받는 거라서 문자로 바꿔주려면 charAt() 함수를 이용합니다.
		char a = sc.next().charAt(0);
		char b = sc.next().charAt(0);
		
		int ia = (int)a;
		int ib = (int)b;
		
		if (ib <= ia) {
			while (ib <= ia ) System.out.println((char)ib++);
		} else if (ia < ib) {
			while (ia <= ib) System.out.println((char)ia++);
		}
		sc.close();
	}
}