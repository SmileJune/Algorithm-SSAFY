package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1541 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String[] arr = sc.nextLine().split("-", 2);
		int numFront = 0;
		StringBuffer sb = new StringBuffer();
		// 앞 쪽 계산
		for (int i = 0; i < arr[0].length(); i++) {
			char ch = arr[0].charAt(i);
			// '+' 만났을때
			if (ch == '+') {
				numFront += Integer.parseInt(sb.toString());
				sb = new StringBuffer();
			}
			// 그 외는 숫자니까 바로 sb에 넣어준다.
			sb.append(ch);
		}
		numFront += Integer.parseInt(sb.toString());
		sb = new StringBuffer();

		if (arr.length == 1) {
			System.out.println(numFront);
			return;
		}

		// 뒤 쪽 계산 (괄호로 전부 음수로 만들 수 있으니까 다 더해서 앞쪽거 빼자)
		int numRear = 0;
		for (int i = 0; i < arr[1].length(); i++) {
			char ch = arr[1].charAt(i);
			// 부호 만났을 때
			if (ch == '+' || ch == '-') {
				numRear += Integer.parseInt(sb.toString());
				sb = new StringBuffer();
				continue;
			}
			sb.append(ch);
		}
		numRear += Integer.parseInt(sb.toString());

		System.out.println(numFront - numRear);
	}

}
