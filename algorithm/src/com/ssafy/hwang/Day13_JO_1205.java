package com.ssafy.hwang;

import java.util.Scanner;

public class Day13_JO_1205 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int len = 0;
		int[] arr = new int[N];
		int maxIdx = 0;
		int tmp=0;
		for(int i = 0; i<arr.length;i++) {
			arr[i] = sc.nextInt();
			maxIdx = Math.max(arr[i], maxIdx);
		}

		int[] cnt = new int[maxIdx+tmp+1];
		
		for(int i=0;i<N;i++) {
			cnt[arr[i]]++;
		}
		int ans = 0;
		
		for(int i =1; i<cnt.length;i++) {
			tmp = cnt[0];
			len =0;
			for(int j=i;j<cnt.length;j++) {
				if(cnt[j]!=0) len++;
				else if(tmp!=0 && cnt[j]==0) {
					tmp--;
					len++;
				}else break;
				
			}
			ans = Math.max(len, ans);
		}
		System.out.println(ans);
	}
}