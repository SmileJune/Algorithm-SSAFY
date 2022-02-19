package com.ssafy.hong;

import java.io.*;
import java.util.*;

public class Boj6571 {
    /**
     * [BOJ: 6571] 피보나치 수의 개수
     * f1:=1
     * f2:=2
     * fn:=f(n-1)+f(n-2) (n>=3)
     * 인 피보나치 수가 있다.
     * 두 수 a,b를 입력 받아 a이상 b이하인 피보나치 수의 개수를 구하라.
     *
     * input:   a b   두 수 a,b
     *          ...
     *          0 0   a==0 && b==0일 때 종료
     * output:  ans   개수
     *          ...
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String[] dp = new String[501];
        dp[1]="1";
        dp[2]="2";
        int idx = 2;
        while(idx<500){
            idx++;
            dp[idx]=sum(dp[idx-1],dp[idx-2]);
        }
        while(true){
            String a= sc.next();
            String b= sc.next();
            if(a.equals("0") && b.equals("0"))break;
            int idx1 = 1, idx2 = 500;
            while(compare(dp[idx1],a)<0)idx1++;
            while(compare(dp[idx2],b)>0)idx2--;

            System.out.println(idx2-idx1+1);

        }
    }
    static int compare(String src, String dst){
        if(src.length() != dst.length())return src.length()>dst.length()?1:-1;
        for(int i=0; i<src.length(); i++){
            if(src.charAt(i) != dst.charAt(i))return src.charAt(i)>dst.charAt(i)?1:-1;
        }
        return 0;
    }

    static String sum(String src, String dst){
        StringBuilder sb = new StringBuilder();
        int s = src.length()-1;
        int d= dst.length()-1;
        int set=0;
        for(;s>=0 && d>=0 ; s--,d--){
            int n = set+dst.charAt(d)-'0'+src.charAt(s)-'0';
            if(n>=10)set=1;
            else set=0;
            sb.append(n%10);
        }
        set = append(s,src,set,sb);
        set = append(d,dst,set,sb);
        if(set==1)sb.append(1);
        return sb.reverse().toString();
    }
    static int append(int idx, String str, int set, StringBuilder sb){
        while(idx>=0){
            int n = str.charAt(idx--)-'0'+set;
            if(n>=10){
                set=1;
            }
            else set=0;
            sb.append(n%10);
        }
        return set;
    }
}
