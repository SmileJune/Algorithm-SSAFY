package com.ssafy.hong;

import java.io.*;
import java.util.*;

public class Boj1517 {
    /**
     * [BOJ: 1517] 버블 소트
     * 길이 N인 배열이 주어질 때, 버블소트를 사용하여 이루어진 swap 횟수를 구하시오.
     *
     * input:   N       배열 길이
     *          a1,a2.. 배열
     * output   ans     swap 횟수
     * @param args
     * @throws IOException
     */
    static long[] seg = new long[1<<19];
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N =Integer.parseInt(br.readLine());

        List<Pair<Integer,Integer>> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            update(i+1,1);
            list.add(new Pair<>(Integer.parseInt(st.nextToken()),i+1));
        }
        list.sort((o1,o2)->{
            if(o2.first == o1.first)
                return o2.second-o1.second;
            return o2.first-o1.first;
        });
        long ans = 0;

        for(Pair<Integer, Integer> p : list){
            ans+=sum(N)-sum(p.second);
            update(p.second,-1);
        }
        System.out.print(ans);
    }
    static void update(int n, long val){
        while(n<=N){
            seg[n]+=val;
            n+=n&-n;
        }
    }
    static long sum(int n){
        long res = 0;
        while(n>0){
            res+=seg[n];
            n-=n&-n;
        }
        return res;
    }
    static class Pair<T,E>{
        T first;
        E second;
        public Pair(T first, E second){this.first=first;this.second=second;}
    }
}
