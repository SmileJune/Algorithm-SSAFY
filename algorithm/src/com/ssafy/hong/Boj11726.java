package com.ssafy.hong;
import java.til.*;

public class Boj11726 {
	
	static int[] dp = new int[1001];
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		final int MOD = 10007;
		dp[0]=1;
		dp[1]=1;
		
		for(int i = 2; i <= N; i++) {
			dp[i]=(dp[i-1]%MOD+dp[i-2]%MOD)%MOD;
		}
		
		System.out.println(dp[N]);
	}
}u
