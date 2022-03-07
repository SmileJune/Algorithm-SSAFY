package com.ssafy.hong;
import java.til.*;

public class Boj1463 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		final int INF = 1<<30;
		
		for(int i=0; i<=N; i++)arr[i] = INF;
		arr[1] = 0;
		for(int i=1; i<N; i++) {
			if(i+1 <= N) arr[i+1] = Math.min(arr[i+1], arr[i]+1);
			if(i*2 <= N) arr[i*2] = Math.min(arr[i*2], arr[i]+1);
			if(i*3 <= N) arr[i*3] = Math.min(arr[i*3], arr[i]+1);
		}
		System.out.println(arr[N]);
	}
}u
