package com.ssafy.hwang;
import java.util.*;
/*
    dp문제다.
    연속된 숫자들의 합중 가장 큰 수를 구해야한다.
    이전까지 숫자의 합보다 지금 숫자가 더 크면 지금 숫자부터 다시 연속시키자.
    즉, dp배열에는 이전까지의 수들의 합 vs 현재 값을 하여 큰값을 넣어주면된다.

    dp[i] = Math.max( dp[i-1] + arr[i] , arr[i] )
    input  => arr[ 2, 1,-4, 3, 4,-4, 6, 5,-5, 1]
    output =>  dp[ 2, 3,-1, 3, 7, 3, 9,14, 9,10]
    만약 현재값이 더 크면 다음 인덱스에서 dp[i-1] = arr[i-1] = 이전 숫자
    마지막에 저 중에 최대값 뽑아주자.
 */
public class Day81_BOJ_1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] dp = new int[N];

        for(int i =0 ; i<N;i++){
            arr[i] = sc.nextInt();
        }
        dp[0] = arr[0];
        for(int i =1 ; i<N;i++){
            dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);
        }
        // arr[i]에서 나올 수 있는 최소값 -1000
        int res=-1000;
        for(int i =0 ; i<N;i++){
            res = Math.max(dp[i],res);
        }
        System.out.println(res);
    }
}
