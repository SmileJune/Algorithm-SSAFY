package com.ssafy.BOJ_SB;

import java.util.Scanner;
 
public class BOJ_2331_반복수열 {
    public static int[][] arr;
 
    public static int[] visit;
    public static int count = 1;
    public static int lastCount = 0;
 
    public static void dfs(int x, int count, int p) {
 
        if (visit[x] == 0) {
 
            visit[x] = count;
 
            String s = Integer.toString(x);
            int len = s.length();
            int cnt = 0;
            for (int j = 0; j < len; j++) {
                cnt += Math.pow(Character.getNumericValue(s.charAt(j)), p);
            }
 
            count++;
 
            dfs(cnt, count, p);
        } else {
 
            lastCount = visit[x] - 1;
            return;
        }
 
    }
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int num = sc.nextInt();
        int p = sc.nextInt();
        visit = new int[1000000];
        dfs(num, count, p);
        System.out.println(lastCount);
 
    }
}
