package com.ssafy.BOJ_SB;
 
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class BOJ_11403_경로찾기 {
 
    // 경로 찾기
    static int[][] map;
    static int n;
    static boolean[]visited;
    private static void solution () {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
 
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
 
        for(int i=0; i<n; i++) {
            visited = new boolean[n];
            for(int j=0; j<n; j++) {
                if(!visited[j] && map[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }
 
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
 
    }
 
    public static void bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(y);
 
        while (!queue.isEmpty()) {
            int data = queue.poll();
 
            for(int i=0; i<n; i++) {
                if(!visited[i] && map[data][i] == 1) {
                    queue.add(i);
                    map[x][i] = 1;
                    visited[i] = true;
                }
            }
        }
    }
 
    public static void main(String[] args) {
        solution();
    }
}