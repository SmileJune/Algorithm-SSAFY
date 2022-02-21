package com.ssafy.hong

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2534 {
    /**
     * c++로 풀리는 로직, 자바는 메모리 초과
     * [BOJ: 2534] 카드배열
     * 카드 N장이 0~N-1 사이의 숫자 중 겹치지 않은 숫자를 갖고 있다.
     * k개의 카드를 선택하여 배열한 순서에 따라 나타나는 N진법의 수 중에서
     * p개의 조건을 충족하는 가장 큰 수와 가장 작은 수를 찾아 그 사이의 값을 출력하라.
     * 조건. Ci > Cj 형태의 제약 조건. (i!=j)
     * input:   N K P   카드 수, 선택한 수, 조건 수
     *          ci cj   조건
     *          ...
     * output:  ans     만들 수 있는 수 중 가장 큰 수와 가장 작은 수의 차
     */ 
    static int N,K,P;
    static int[] M;
    static int[] m;
    static List<Integer>[][] adj;
    static int[][] degree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        M = new int[K];
        m = new int[K];
        adj = new ArrayList[2][K];
        degree = new int[2][K];
        for(int i=0; i<K; i++){
            adj[0][i]=new ArrayList<>();
            adj[1][i]=new ArrayList<>();
        }
        for(int i=0; i<P; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj[0][e].add(s);
            degree[0][s]++;

            adj[1][s].add(e);
            degree[1][e]++;
        }
        setValue(N-K-1,1,1);
        setValue(K,-1,0);

        for(int i=0; i<K; i++)M[i]-=m[i];
        long ans = M[0];
        long sum = 1;
        long MOD = 1000000007;
        for(int i=1; i<K; i++){
            sum*=N;
            sum%=MOD;
            ans+=sum*M[i]%MOD;
            ans%=MOD;
        }
        System.out.println(ans);
    }

    static void setValue(int init, int d, int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o1-o2);
        int val=init;
        for(int i=0; i<K; i++)if(degree[n][i]==0)pq.add(i);
        while(!pq.isEmpty()){
            int curr = pq.poll();
            val+=d;
            if(n==1) M[curr]=val;
            else m[curr]=val;

            for(int next : adj[n][curr]){
                degree[n][next]--;
                if(degree[n][next]==0){
                    pq.add(next);
                }
            }
        }
    }
}
