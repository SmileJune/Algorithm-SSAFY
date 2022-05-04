package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class BOJ_5567_결혼식 {
    static int N,M;
    static boolean friend[];
    static ArrayList<Integer> list[];
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        friend = new boolean[N+1];
        list = new ArrayList[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();

        M = Integer.parseInt(br.readLine());

        for(int m=0;m<M;m++){
            String str[] = br.readLine().split(" ");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);

            list[start].add(end);
            list[end].add(start);
        }
        dfs(1,1);

        for(int i=2;i<=N;i++){
            if(friend[i]) result++;
        }

        System.out.println(result);
    }

    static void dfs(int v,int cnt){
        if(cnt == 3) return;

        Iterator<Integer> it = list[v].iterator();
        //friend[v] = true;

        while(it.hasNext()){
            //친구 & 친구의 친구
            int num = it.next();
            friend[num] = true;
            dfs(num,cnt+1);
        }
    }
}