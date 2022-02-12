package com.ssafy.hong;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj2110 {

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
