package com.ssafy.hong;
import java.io.*;
import java.util.*;

public class Boj16225 {
    /**
     * [BOJ: 16225] 제 271회 웰노운컵
     * 인공지능 vs 나
     * 내가 카드 2장 선택, 인공지능이 2장 중 자신에게 유리한 카드 선택
     * 남은 카드 내가 선택.
     * 카드마다 내가 얻을 수 있는 점수와 인공지능이 얻을 수 있는 점수가 나타나 있음.
     * 내가 얻을 수 있는 최대 점수는?
     * 
     * input:   N       카드 수
     *          a1 a2.. 내가 얻을 수 있는 점수
     *          b1 b2.. 인공지능이 얻을 수 있는 점수
     * output:  ans     내가 얻은 점수들 총합의 최대
     */
    static final int MAX=200001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        List<Pair> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st2.nextToken())));
        }
        list.sort((p1,p2)->p1.s-p2.s);
        long ans = list.get(0).f;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
        for(int i=1; i<N-1; i+=2){
            pq.add(list.get(i).f);
            pq.add(list.get(i+1).f);
            ans+=pq.poll();
        }
        System.out.println(ans);
    }
    static class Pair{
        int f, s;
        Pair(int f, int s){this.f=f;this.s=s;}
    }
}
