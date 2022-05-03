package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_17070_파이프옮기기1 {
	static class pipe{
        int i;
        int j;
        int dir;
        public pipe(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.dir = d;
        }
    }
    static int[][] map;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(inputs[j-1]);
            }
        }
        if(map[n][n]==1){
            System.out.println(0);
            return;
        }     
        Queue<pipe> q = new LinkedList<>();
        q.add(new pipe(1, 2, 0));
        int count = 0;

        while (!q.isEmpty()) {
            pipe now = q.poll();

            if (now.i == n && now.j == n) {
                count++;
                continue;
            }
            if (now.dir == 0) {

                if(isPossible(now, 0)){
                    q.add(new pipe(now.i, now.j + 1, 0));
                }

                if(isPossible(now, 2)) {
                    q.add(new pipe(now.i + 1, now.j + 1, 2));
                }

            }else if(now.dir == 1){ 
            
                if(isPossible(now, 1)){ 
                    q.add(new pipe(now.i+1, now.j, 1));
                }

                if(isPossible(now, 2)) { 
                    q.add(new pipe(now.i + 1, now.j + 1, 2));
                }
                
            }else{ 
            
                if(isPossible(now, 0)){ 
                    q.add(new pipe(now.i, now.j + 1, 0));
                }
                
                if(isPossible(now, 1)){ 
                    q.add(new pipe(now.i+1, now.j, 1));
                }
               
                if(isPossible(now, 2)) {
                    q.add(new pipe(now.i + 1, now.j + 1, 2));
                }               
            }
        }
        if(count==0) {
            System.out.println(0);
        }else {
            System.out.println(count);
        }
    }
    public static boolean isPossible(pipe now, int direction){
        switch (direction){
            case 0 :
                return now.j+1<=n && map[now.i][now.j+1] != 1;
            case 1:
                return now.i+1<=n && map[now.i+1][now.j] != 1;
            case 2:
                return now.i+1<=n && now.j+1<=n && map[now.i][now.j + 1] != 1 && map[now.i + 1][now.j + 1] != 1 && map[now.i + 1][now.j] != 1;
        }
        return false;
    }
}