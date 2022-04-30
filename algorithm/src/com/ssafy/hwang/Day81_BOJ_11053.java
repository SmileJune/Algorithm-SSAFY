package com.ssafy.hwang;
import java.util.*;

public class Day81_BOJ_11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i =0 ; i<N;i++){
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[N];
        int res = 0;
        // 바깥 for문이 기준점
        for(int i =0;i<N;i++){
            // 최소 1이기 때문에 dp[i] = 1 초기화
            dp[i] = 1;
            // 기준점 전까지의 수들을 깊이를 비교하면서 깊이를 늘려간다
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        System.out.println(res);
    }
}

