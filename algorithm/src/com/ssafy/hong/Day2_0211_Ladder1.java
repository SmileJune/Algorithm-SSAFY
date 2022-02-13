package com.ssafy.hong;

import java.util.*;

public class Day2_0211_Ladder1 {
    static int[][] arr = new int[101][101];
    static int N=100;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = 10, t;

        while(T-->0){
            t=sc.nextInt();

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++)arr[i][j]=sc.nextInt();
            }
            int ans=0;
            for(int i=0; i<N; i++)if(isPossible(i)){ans=i;break;}
            System.out.printf("#%d %d\n",t,ans+1);
        }
    }
    static boolean isPossible(int n){
        int r=0;
        int[] dn={1,-1};
        while(r<N){
            for(int i=0; i<2; i++){
                int tn = n+dn[i];
                if(tn<0 || tn>=N || arr[r][tn]==0)continue;
                while(tn>=0 && tn<=N-1){
                    if(arr[r][tn]==1)tn+=dn[i];
                    else break;
                }
                n=tn-dn[i];
                break;
            }
            r++;
        }
        return arr[r-1][n]==2?true:false;
    }
}

