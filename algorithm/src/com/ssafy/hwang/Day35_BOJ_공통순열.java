package com.ssafy.hwang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 문자열 문제
 * 
 * 조건에 입력 갯수에 대한 조건이 없다 => EOF (End Of File)
 * 
 * 
 * @author kwan
 *
 */
public class Day35_BOJ_공통순열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Character> ans = new ArrayList<>();
		while(sc.hasNext()) {
			char[] cArr1 = sc.nextLine().toCharArray();
			char[] cArr2 = sc.nextLine().toCharArray();
			
			for(int i = 0; i < cArr1.length; i ++) {
				for(int j = 0 ; j < cArr2.length; j ++) {
					
					if(cArr1[i]== cArr2[j]) {
						ans.add(cArr1[i]);
						cArr2[j] = 'A';
						break;
					}
				}
			}
			java.util.Collections.sort(ans);
			for(int i = 0 ; i< ans.size();i++) {
				System.out.print(ans.get(i));
			}
			System.out.println();
			ans.clear();
		}

	}
}
