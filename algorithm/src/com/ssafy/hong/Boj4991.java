package com.ssafy.hong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj4991 {

    /**
     * [BOJ: 4991] 로봇 청소기
     * 일부 칸에는 가구가 놓여져 있고,가구의 크기도 1×1이다. 
     * 로봇 청소기는 가구가 놓여진 칸으로 이동할 수 없다.
     * 로봇은 한 번 움직일 때, 인접한 칸으로 이동할 수 있다. 
     * 또, 로봇은 같은 칸을 여러 번 방문할 수 있다.
     * 방의 정보가 주어졌을 때, 더러운 칸을 모두 깨끗한 칸으로 만드는데 필요한 
     * "이동 횟수의 최솟값"을 구하는 프로그램을 작성하시오.
     * 
     * input:   M N     열, 행
     *          str..   행별 방정보
     *          ...     N==0 && M==0나올떄 까지 반복
     * output   ans     최소 이동거리, 청소하지 못하면 -1
     * @param args
     * @throws IOException
     */
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[22][22];
        int [][][] dp = new int[22][22][1<<10];
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,1,-1};

        final int INF=1<<30;
        boolean [][][] visit = new boolean[22][22][1<<10];
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            if(N==0 && M==0)break;
            int sy=0, sx=0, n='0';

            for(int i=0; i<N; i++){
                map[i]=br.readLine().toCharArray();
                for(int j=0; j<M; j++){
                    if(map[i][j]=='o'){
                        sy=i;sx=j; map[i][j]='.';
                    }
                    if(map[i][j]=='*'){
                        map[i][j]=(char)n++;
                    }
                }
            }
            int limit = (1<<(n-'0'))-1;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    for(int k=0; k<=limit; k++){
                        dp[i][j][k]=INF;
                        visit[i][j][k]=false;
                    }
                }
            }

            PriorityQueue<Pair<Pair<Integer,Integer>,Pair<Integer,Integer>>> pq = new PriorityQueue<>(new Comparator<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>>() {
                @Override
                public int compare(Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> o1, Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> o2) {
                    if(o1.first.first == o2.first.first && o1.first.second ==o2.first.second && o1.second.first == o2.second.first)
                        return o1.second.second-o2.second.second;
                    if(o1.first.first == o2.first.first && o1.first.second ==o2.first.second)
                        return o1.second.first-o2.second.first;
                    if(o1.first.first == o2.first.first)
                        return o1.first.second - o2.first.second;
                    return o1.first.first - o2.first.first;

                }
            });
            pq.add(new Pair<>(new Pair<>(0,sy), new Pair<>(sx,0)));
            dp[sy][sx][0]=0;
            while(!pq.isEmpty()){
                int cy,cx,cs;
                do{
                    Pair<Pair<Integer,Integer>,Pair<Integer,Integer>> tmp= pq.poll();
                    cy=tmp.first.second;
                    cx=tmp.second.first;
                    cs=tmp.second.second;
                }while(!pq.isEmpty() && visit[cy][cx][cs]);
                if(visit[cy][cx][cs])break;
                visit[cy][cx][cs]=true;

                for(int i=0; i<4; i++){
                    int ty=cy+dy[i], tx=cx+dx[i];
                    if(ty<0 || tx<0 || ty>=N || tx>=M)continue;
                    if(map[ty][tx]=='x')continue;

                    if(map[ty][tx]=='.'){
                        if(dp[ty][tx][cs]>dp[cy][cx][cs]+1){
                            dp[ty][tx][cs]=dp[cy][cx][cs]+1;
                            pq.add((new Pair<>(new Pair<>(dp[ty][tx][cs],ty), new Pair<>(tx,cs))));
                        }
                    }
                    else{
                        int ts = cs|(1<<(map[ty][tx]-'0'));
                        if(dp[ty][tx][ts]>dp[cy][cx][cs]+1){
                            dp[ty][tx][ts]=dp[cy][cx][cs]+1;
                            pq.add((new Pair<>(new Pair<>(dp[ty][tx][ts],ty), new Pair<>(tx,ts))));
                        }
                    }
                }
            }

            int ans = INF;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++)if(ans>dp[i][j][limit])ans=dp[i][j][limit];
            }

            System.out.printf("%d\n",ans==INF?-1:ans);
        }
    }
    static class Pair <T,E>{
        T first;
        E second;
        public Pair(T first, E second){this.first=first;this.second=second;}


    }
}
