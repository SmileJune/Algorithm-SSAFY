package com.ssafy.hong;
import java.util.Arrays;
import java.util.Scanner;

public class Boj2230 {
	/**
	 * [BOJ: 2230] 수 고르기
	 * N개의 정수로 이루어진 수열에서 두 수를 골랐을 때,
	 * 두 수의 차가 M이상이면서 제일 작은 경우를 구하라.
	 * 
	 * iuput:	N  M	수열 크기, 기준값
	 * 			a1		수열
	 * 			a2
	 * 			..
	 * output:	ans		M 이상이며 제일 작은 경우
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++)arr[i]=sc.nextInt();
		Arrays.sort(arr);
		int ans = (1<<31)-1;
		for(int i=0; i<N && arr[i]+M<=arr[N-1]; i++) {
			int l = -1, h = N;
			while(l+1<h) {
				int mid=(l+h)>>1;
				if(arr[mid]-arr[i]>=M)h=mid;
				else l=mid;
			}
			if(ans > arr[h]-arr[i])ans=arr[h]-arr[i];
		}
		System.out.println(ans);
	}
}
