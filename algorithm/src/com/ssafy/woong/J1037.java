package com.ssafy.woong;

import java.util.Scanner;

public class J1037 {

	static Scanner sc = new Scanner(System.in);
	static String[][] map;
	static int n;
	public static void main(String[] args) {

		String ans = "Corrupt";
		n = sc.nextInt();
		sc.nextLine();
		map = new String[n][n];
		
		for(int i = 0 ; i < n; i++) {
			map[i] = sc.nextLine().split(" ");
		}
		
		String rowAns = rowCheck(map);
		String colAns = colCheck(map);
		
		if(rowAns.equals("ok") && colAns.equals("ok")) {
			ans = "OK";
		}
		else if(rowAns.equals("Corrupt") || colAns.equals("Corrupt")) {
			ans = "Corrupt";
		}
		else {
			ans = "Change bit (" + rowAns + "," + colAns + ")";
		}
		System.out.println(ans);
	}
	
	static String rowCheck(String[][] map) {
		int cnt = 0;
		int errPoint = 0;
		for(int i = 0; i < n; i++) {
			int evenCnt = 0;
			for(int j = 0; j < n; j++) {
				if(map[i][j].equals("1")){
					evenCnt = (evenCnt + 1) % 2;
				}
			}
			if(evenCnt == 0) {
				cnt++;
			}
			else {
				errPoint = i;
			}
			
		}
		if(cnt == n) {
			return "ok";
		}
		else if(cnt == n - 1) {
			return String.valueOf(errPoint + 1);
		}
		return "Corrupt";
		
	}
	
	static String colCheck(String[][] map) {
		int cnt = 0;
		int errPoint = 0;
		for(int i = 0; i < n; i++) {
			int evenCnt = 0;
			for(int j = 0; j < n; j++) {
				if(map[j][i].equals("1")){
					evenCnt = evenCnt == 1 ? 0 : 1;
				}
			}
			if(evenCnt == 0) {
				cnt++;
			}
			else {
				errPoint = i;
			}
			
		}
		if(cnt == n) {
			return "ok";
		}
		else if(cnt == n - 1) {
			return String.valueOf(errPoint + 1);
		}
		return "Corrupt";
		
	}
}
