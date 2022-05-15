package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504_특정한최단경로 {
	static int N, E;
    static ArrayList<node>[] list;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<node>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[v1].add(new node(v2, weight));
            list[v2].add(new node(v1, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long res1 = dik(1, v1) + dik(v1, v2) + dik(v2, N);
        long res2 = dik(1, v2) + dik(v2, v1) + dik(v1, N);

        if (Math.min(res1, res2) >= Integer.MAX_VALUE) {
            sb.append("-1\n");
        } else {
            sb.append(String.valueOf(Math.min(res1, res2)));
        }
        System.out.println(sb);
    }

    static long dik(int start, int end) {
        boolean[] check = new boolean[N + 1];
        PriorityQueue<node> q = new PriorityQueue<node>();
        q.offer(new node(start, 0));

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!q.isEmpty()) {
            node curNode = q.poll();
            int cur = curNode.end;

            if (check[cur])
                continue;
            check[cur] = true;

            for (node node : list[cur]) {
                if (dist[node.end] > dist[cur] + node.weight) {
                    dist[node.end] = dist[cur] + node.weight;
                    q.offer(new node(node.end, dist[node.end]));
                }
            }
        }
        return dist[end];
    }
}

class node implements Comparable<node> {
    int end, weight;

    public node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(node o) {
        return weight - o.weight;
    }
}