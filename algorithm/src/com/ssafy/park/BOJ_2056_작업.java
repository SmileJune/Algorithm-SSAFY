package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2056_작업 {
	static int N;
    static int cost[], arr[], pre[];
    static ArrayList<Integer> arrList[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N+1];
        arr = new int[N+1];
        pre = new int[N+1];
        arrList = new ArrayList[N+1];
        for(int i=0; i<=N; i++)
            arrList[i] = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            for(int j=0; j<val; j++) {
                int prev = Integer.parseInt(st.nextToken());
                arrList[prev].add(i);
                pre[i]++;
            }
        }              
        bfs();
        int maxValue = 0;
        for(int i : arr) {
            maxValue = Math.max(maxValue, i);
        }
        System.out.println(maxValue);
    }
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();         
        for(int i=1; i<=N; i++) {
            if(pre[i] == 0) {
                queue.add(i);
                arr[i] = cost[i];
            }
        }       
        while(!queue.isEmpty()) { 
            int num = queue.poll();          
            for(int i=0; i<arrList[num].size(); i++) {
                int next = arrList[num].get(i);
                if(arr[next] < arr[num] + cost[next])
                    arr[next] = arr[num] + cost[next];
                if(--pre[next] == 0) {
                    queue.add(next);
                }
            }
        }
        
    }
}