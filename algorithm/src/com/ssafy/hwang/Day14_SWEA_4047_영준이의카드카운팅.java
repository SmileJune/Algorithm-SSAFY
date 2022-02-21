package com.ssafy.hwang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day14_SWEA_4047_영준이의카드카운팅 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		outer : for (int tc = 1; tc <= T; tc++) {
			List<String> list = new ArrayList<>();
			String str = sc.next();
			
					//     S, D,  H,  C s11
			int[] arr = { 13, 13, 13, 13 };
			for (int i = 0; i < str.length(); i += 3) {
				arr["SDHC".indexOf(str.charAt(i) + "")]--;
				
				if(list.contains(str.substring(i,i+3))) {
					System.out.printf("#%d ERROR\n",tc);
					continue outer;
				}
				list.add(str.substring(i,i+3));
			}

			System.out.print("#"+tc);
			for(int i=0;i<arr.length;i++) {
				System.out.print(" "+arr[i]);
			}System.out.println();
		}
		sc.close();
	}
}