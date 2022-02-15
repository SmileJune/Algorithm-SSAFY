package com.ssafy.hong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj2095 {
    /**
     * [BOJ: 2094] 강수량
     * "X년도에는 Y년도 이후 가장 많은 비가 내렸다"를 만족하기 위한 조건
     * 1. Y년도, X년도 그리고 그 사이의 모든 년도들의 강수량에 대한 정보가 존재해야 한다.]
     * 2. X년도 강수량 <= Y년도 강수량
     * 3. Y<Z<X를 만족하는 모든 Z들에 대해 Z년도 강수량 < X년도 강수량
     *
     * 두 년도가 주어질 때 위 조건을 모두 만족하면 "true", 알려지지 않은 경우 강수량을 잘 조절 하여
     * 조건을 만족할 수 있으면 "maybe", 불가능하면 "false"를 출력
     *
     * input:  N     년도 수
     *         y1 r1 년도 강수량
     *         ...
     *         M     궁금한 년도 수
     *         y1 x1 x1년도에 y1년도 이후 가낭 많은 비가 내렸다
     *         ...
     * output: ans  조건 가능 여부
     *         ...
     * @param args
     */
    static int MAX=1<<18, S=1<<17;
    static int[] seg = new int[MAX];
    static List<Integer> arr = new ArrayList<>();
    static int N,M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i=0; i<N; i++){
            arr.add(sc.nextInt());
            seg[S+i]=sc.nextInt();
        }
        for(int i=S-1; i>0; i--){
            seg[i]= (seg[i * 2] >= seg[i * 2 + 1]) ? seg[i * 2] : seg[i * 2 + 1];
        }

        M = sc.nextInt();
        while(M-->0){
            int y=sc.nextInt();
            int x=sc.nextInt();
            print(getAns(y,x));
        }
    }
    static void print(int n){
        System.out.printf("%s\n", n==0?"false":n==1?"true":"maybe");
    }

    static int getAns(int y, int x){
        int yy = lower_bound(y);
        int xx = lower_bound(x);

        boolean isY = yy<N && arr.get(yy)==y;
        boolean isX = xx<N && arr.get(xx)==x;
        boolean isC = isY && isX && yy-xx==y-x;

        int res = get(yy+(isY?1:0), xx-1);

        if(isY && isX){
            if(seg[S+yy] < seg[S+xx] || res>=seg[S+xx]) return 0;
            else if(isC) return 1;
        }
        else if(isY){
            if(seg[S+yy]<=res)return 0;
        }
        else if(isX){
            if(seg[S+xx]<=res)return 0;
        }
        return 2;
    }
    static int get(int l, int r){
        return get(l,r,1,0,S-1);
    }
    static int get(int l, int r, int n, int s, int e){
        if(r<s || e<l)return -1;
        if(l<=s&&e<=r)return seg[n];
        int mid=(s+e)/2;
        return Math.max(get(l,r,n*2,s,mid),get(l,r,n*2+1,mid+1,e));
    }
    static int lower_bound(int n){
        int lo=-1, hi=N;
        while(lo+1<hi){
            int mid=(lo+hi)/2;
            if(arr.get(mid) >= n)hi=mid;
            else lo=mid;
        }
        return hi;
    }
}

