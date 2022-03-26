package com.ssafy.park;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	static String input;
    static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int begin;
    static StringTokenizer st;
    static int map[][];
    static boolean visited[];
    static StringBuilder dfsResult = new StringBuilder();
    static StringBuilder bfsResult = new StringBuilder();

    static void dfs(int begin){
        visited[begin] = true;
        dfsResult.append(Integer.toString(begin) + " ");
        for(int i=1; i<N+1; i++){
            if(map[begin][i]==1 && visited[i]==false){
                dfs(i);
            }
        }
    }

    static void bfs(int begin){
        Queue<Integer> q = new LinkedList<>();
        q.add(begin);
        visited[begin] = true;

        while(!q.isEmpty()){
            int temp = q.poll();
            bfsResult.append(Integer.toString(temp) + " ");

            for(int i=1; i<N+1; i++){
                if(map[temp][i]==1 && visited[i]==false){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        st = new StringTokenizer(bfr.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        begin = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(bfr.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }

        dfs(begin);
        bfw.write(dfsResult.toString());
        bfw.newLine();

        visited = new boolean[N+1];
        bfs(begin);
        bfw.write(bfsResult.toString());

        bfw.close();
    }
}