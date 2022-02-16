package com.ssafy.hong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M=1<<18, S=1<<17;
    static int[] seg = new int[M];
    static boolean[] lazy = new boolean[M];
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        for(int i =0; i<M; i++){
            int n = sc.nextInt();
            int s = sc.nextInt()-1;
            int e = sc.nextInt()-1;

            if(n==0){
                update(s,e,1,0,S-1);
            }
            else{
                System.out.printf("%d\n",sum(s,e,1,0,S-1));
            }
        }
    }

    static void update(int s, int e, int n, int ss, int ee){
        propa(n,ss,ee);
        if(e<ss||ee<s)return;
        if(s<=ss&&ee<=e){
            lazy[n]^=true;
            propa(n,ss,ee);
            return;
        }
        int mid= (ss+ee)/2;
        update(s,e,n*2,ss,mid);
        update(s,e,n*2+1,mid+1,ee);
        seg[n]=seg[n*2]+seg[n*2+1];
    }
    static int sum(int s, int e, int n, int ss, int ee){
        propa(n,ss,ee);
        if(e<ss||ee<s) return 0;
        if(s<=ss&&ee<=e) return seg[n];

        int mid= (ss+ee)/2;
        return sum(s,e,n*2,ss,mid) + sum(s,e,n*2+1,mid+1,ee);
    }
    static void propa(int n, int ss, int ee){
        if(!lazy[n]) return;
        if(n<S){
            lazy[n*2]^=true;
            lazy[n*2+1]^=true;
            seg[n]=(ee-ss+1)-seg[n];
        }
        else{
            seg[n]^=1;
        }
        lazy[n]=false;
    }

}
