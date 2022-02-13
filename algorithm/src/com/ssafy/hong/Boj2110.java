package com.ssafy.hong;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj2110 {
	
    /**
     * [BOj: 2110] 공유기 설치
     * N개의 집 수직선 위에 있다.
     * 공유기 C개를 설치하려고 한다.
     * 최대한 많은 곳에서 와이파이 사용하기 위해서 인접한 공유기 사이의 거리를
     * 최대로 할때, 이 거리는?
     * input:   N C 집 수, 공유기 수
     *          a1  집 위치
     *          ..
     * output:  ans 인접한 두 공유기 사이 최대 거리
     * @param args
     * @throws IOException
     */
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            list.add(sc.nextInt());
        }
        list.sort((o1,o2)->  o1-o2);

        int lo=-1, hi=list.get(list.size()-1);
        while(lo+1<hi){
            int mid = (lo+hi)/2;
            if(isPossible(mid, C, list))lo=mid;
            else hi=mid;
        }
        System.out.println(hi);
    }
    static boolean isPossible(int mid, int val, List<Integer> list){
        int cnt = 1;
        int prev = list.get(0);
        for(int i=1; i<list.size(); i++){
            if(list.get(i)-prev>mid){
                cnt++;
                prev=list.get(i);
            }
        }
        return cnt < val ? false: true;
    }
}
