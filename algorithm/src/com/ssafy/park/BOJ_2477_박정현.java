package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477_박정현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int no = Integer.parseInt(br.readLine());
		int[][] arr = new int[2][7];
		for (int i = 1; i <=6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j <2; j++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
				if (i == 6) {
					arr[j][0] = arr[j][i];
				}
			}
		}
		int smallarea = 0;
		for (int i = 0; i < 7; i++) {
			if(arr[0][i+1] != sel(arr[0][i])) {
				smallarea = arr[1][i+1] * arr[1][i];
				arr[1][0] = 0;
				for (int j = 1; j <=6; j++) {
					if (arr[0][j] == arr[0][i] || arr[0][j] == arr[0][i+1]) {
						arr[1][j] = 0;
					}
				}
				break;
			}
		}
		
		int area = 1;
		for (int i = 1; i<= 6; i++) {
			if (arr[1][i] != 0) area *= arr[1][i];
		}
		area -= smallarea;
		System.out.println(area*no);
	}
	
	public static int sel(int a) {
		switch (a) {
		case 1 :
			return 4;
		case 2 :
			return 3;
		case 3 :
			return 1;
		case 4 :
			return 2;
		}
		return 0;
	}
}
