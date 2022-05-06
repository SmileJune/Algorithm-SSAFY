package com.ssafy.park;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_16938_캠프준비 {
	static int[] problems;
    static int N;
    static int L;
    static int R;
    static int X;
    static int ans = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);
        X = Integer.parseInt(input[3]);
        problems = new int[N];

        input = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            problems[i] = Integer.parseInt(input[i]);
        }

        dfs(0, -1, 1000001, 0, 0);

        System.out.println(ans);
    }

    public static void dfs(int idx, int max, int min, int sum, int cnt) {
        if(cnt>=2) {
            if(sum>=L && sum<=R && max-min>=X)
                ans++;
        }

        if(idx==N) return;

        for(int i=idx; i<N; i++) {
            dfs(i+1, Math.max(max, problems[i]), Math.min(problems[i], min), sum+problems[i], cnt+1);
        }
    }
}
