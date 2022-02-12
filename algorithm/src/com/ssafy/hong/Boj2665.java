package com.ssafy.hong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj2665 {
    /**
     * [BOJ: 2565] 전깃줄
     * 전봇대 A와 B사이에 전깃줄을 추가하다보니 서로 교차함.
     * 모든 전깃줄이 교차하지 않게 제거해야 하는 전깃줄의 최소 개수 구하기
     *
     * input:   N   전깃줄 수
     *          a b A의 a번 전봇대와 B의 b번 전봇대를 연결
     *          ...
     * output:  ans 삭제하는 최소 전깃줄 수
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Pair<Integer,Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<N; i++){
            list.add(new Pair<>(sc.nextInt(),sc.nextInt()));
        }
        list.sort((o1,o2)->{
            if(o1.first!=o2.first)return o2.first-o1.first;
            return o2.second-o1.second;
        });

        for(int i=0; i<N; i++){
            int idx=bs(ans, list.get(i).second);

            if(idx == ans.size())ans.add(list.get(i).second);
            else ans.set(idx, list.get(i).second);
        }
        System.out.println(list.size()-ans.size());
    }

    static int bs(List<Integer>list, int val){
        int lo=-1, hi=list.size();
        while(lo+1<hi){
            int mid=(lo+hi)>>1;
            if(list.get(mid) <= val)hi=mid;
            else lo=mid;
        }
        return hi;
    }


    static class Pair<T,E>{
        T first;
        E second;
        public Pair(T first, E second){this.first=first; this.second=second;}
    }

}
