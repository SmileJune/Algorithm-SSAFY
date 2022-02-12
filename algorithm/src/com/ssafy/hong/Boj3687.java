package com.ssafy.hong;

import java.util.Scanner;

public class Boj3687 {
    static String[] dp;
    static int[] num = {0,0,1,7,4,2,0,8};

    /**
     * [BOJ: 3687] 성냥개비
     * 성냥개비의 개수가 주어질 때 성냥개비를 모두 사용해서
     * 만들 수 있는 가장 큰 수와 가장 작은 수를 출력
     * input:   T       테스트케이스 수
     *          n       성냥 수
     *          ..
     * output:  min max 최소 수, 최대 수
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =  sc.nextInt();

        while(N-- > 0){
            int t = sc.nextInt();
            dp = new String[101];
            for(int i=0; i<=t; i++)dp[i]="";
            System.out.printf("%s %s\n",recur(t,0),getMax(t));
        }

    }
    static String getMax(int match){
        StringBuffer sb = new StringBuffer();
        sb.append(match%2==0?"1":"7");
        int idx=1;
        while(idx++<match/2){
            sb.append("1");
        }
        return sb.toString();
    }

    static String recur(int match, int idx){
        if(match==0 || dp[match].length()>0)return dp[match];
        for(int i=2; i<=7; i++)if(match - i >=0 && match - i != 1) {
            String temp = "";
            if (i == 6) {
                if (idx == 0) temp += "6";
                else temp += "0";
            } else temp += num[i];

            temp += recur(match-i, idx+1);
            dp[match]=dp[match].length()==0?temp:getMin(temp,dp[match]);
        }
        return dp[match];
    }
    static String getMin(String src, String dst){
        if(src.length()!=dst.length())return src.length()>dst.length()?dst:src;
        for(int i=0; i<src.length(); i++)if(src.charAt(i)!=dst.charAt(i))return src.charAt(i)>dst.charAt(i)?dst:src;
        return src;
    }
}

