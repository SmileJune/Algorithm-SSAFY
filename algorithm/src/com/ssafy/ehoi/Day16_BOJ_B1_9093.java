package com.ssafy.ehoi;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Day16_BOJ_B1_9093 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		StringTokenizer st; 
		
		int T = Integer.parseInt(sc.nextLine()); //  항상 정수 이렇게 쓰기!!! 
		
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(sc.nextLine()); // 뭘 먹었지
			
			while(st.hasMoreTokens()) {
				sb = new StringBuilder();
				String str = st.nextToken();
				System.out.print(sb.append(str).reverse().append(" "));
			}
//			sb.append("\n");
			System.out.println();
		}
//		System.out.println(sb);
		sc.close();
	}

}
