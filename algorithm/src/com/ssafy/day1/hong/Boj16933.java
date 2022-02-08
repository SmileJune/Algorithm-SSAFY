package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj16933 {
    /**
     * [BOJ: 16933] 벽 부수고 이동하기 3
     * 최단 거리로 (1,1)~(N,M) 도착하기
     * 벽 k개 부술 수 있고, 낮에만 부술 수 있음
     * 시작하는 칸과 끝나는 칸도 답에 포함
     * input:   N M K   행, 열, 부술 수 있는 벽 수
     *          010..   0: 빈곳, 1: 벽
     *          ...
     * output:  ans 최단거리, 불가능 = -1
     * @param args
     */
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    static String[] map = new String[1001];
    static boolean[][][] visit = new boolean[1001][1001][11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();


        for(int i=0; i<N; i++) {
            map[i] = sc.next();
        }
        visit[0][0][0] = true;
        Pos start = new Pos(0,0,0, 1,true);
        Queue<Pos> queue = new LinkedList<>();
        queue.add(start);
        int ans = (int)1e9;
        while(!queue.isEmpty()){
            Pos curr = queue.poll();
            if(curr.x==M-1 && curr.y ==N-1){
                ans = Math.min(ans, curr.c);
            }
            for(int i=0; i<4; i++){
                int ty = curr.y + dy[i];
                int tx = curr.x + dx[i];
                if(!isOk(tx,ty,N,M))continue;
                if(curr.isSun){
                    if(map[ty].charAt(tx) == '0'){
                        if(!visit[ty][tx][curr.k]){
                            visit[ty][tx][curr.k]=true;
                            queue.add(new Pos(ty,tx, curr.k, curr.c+1, false));
                        }
                    }
                    else{
                        if(curr.k < K && !visit[ty][tx][curr.k+1]){
                            visit[ty][tx][curr.k+1]=true;
                            queue.add(new Pos(ty,tx, curr.k+1, curr.c+1, false));
                        }
                    }
                }
                else{
                    if(map[ty].charAt(tx) == '0'){
                        if(!visit[ty][tx][curr.k]){
                            visit[ty][tx][curr.k]=true;
                            queue.add(new Pos(ty,tx, curr.k, curr.c+1, true));
                        }
                    }
                    else{
                        if(curr.k < K){
                            queue.add(new Pos(curr.y, curr.x, curr.k, curr.c+1, true));
                        }
                    }
                }
            }
        }

        System.out.println(ans==(int)1e9?-1:ans);
    }
    static boolean isOk(int x, int y, int N, int M){
        if(x<0 || y<0 || x>=M || y>=N)return false;
        return true;
    }
    static class Pos{
        int y, x, k, c;
        boolean isSun;

        public Pos(int y, int x, int k, int c, boolean isSun){this.c =c;this.y = y;this.x = x;this.k=k;this.isSun=isSun;}
    }
}

