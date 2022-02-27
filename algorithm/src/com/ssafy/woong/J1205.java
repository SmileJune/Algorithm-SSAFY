package com.ssafy.woong;
import java.util.Arrays;
import java.util.Scanner;

public class J1205 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		String[] str = sc.nextLine().split(" ");
		int[] arr = new int[str.length];
		
		for(int i = 0 ; i < str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		Arrays.sort(arr);
		
		int zeroNum = 0;
		int tmp = 1;
		int idx;
		
		for(idx = 0; idx < arr.length && arr[idx] == 0 ; idx++,zeroNum++) {};
		int cnt = zeroNum;
		int maxLen = idx;
		
		
		for(int i = zeroNum ; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j-1] == arr[j]) {
					continue;
				}
				
				int need = arr[j] - arr[j-1] - 1;
				if(cnt >= need) {
					cnt -= need;
					tmp += need + 1;
				}
				else{
					break;
				}
			}
			tmp += cnt;
			maxLen = tmp > maxLen ? tmp : maxLen;
			cnt = zeroNum;
			tmp = 1;
		}
		
		System.out.println(maxLen);
		
	}
}