package com.ssafy.woong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B4153 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int[] arr = new int[3];
		
		while(true){
			String str = "wrong";
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 3; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			if(Arrays.stream(arr).sum() == 0)return;
			if(isOk(arr))str = "right";
			System.out.println(str);
		}
	}
	
	static boolean isOk(int[] arr) {
		
		Arrays.sort(arr);
		if(Math.pow(arr[0], 2) + Math.pow(arr[1], 2) == Math.pow(arr[2], 2)) {
			return true;
		}
		return false;
	}

}
