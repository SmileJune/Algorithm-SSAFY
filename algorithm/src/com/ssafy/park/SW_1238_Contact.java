package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1238_Contact {
	
	static int[][] adjArr;
	static int ans;
    public static void main(String[] args) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int E = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken()); 
            adjArr = new int[101][101];
            st = new StringTokenizer(reader.readLine());
            for (int i = 0; i < E; i += 2) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjArr[from][to] = 1;
            }
            ans = 0;
            bfs(S);
            sb.append("#" + tc + " " + ans + "\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = 0;
            while(size > 0) {
            	int temp = queue.poll();
            	max = Math.max(max, temp);
            	for (int i = 1; i < 101; i++) {
            		if (adjArr[temp][i] == 1 && !visited[i]) {
            			queue.add(i);
            			visited[i] = true;
            		}
            	}
            	size--;
            }
            ans = max;
        }
    }
}

