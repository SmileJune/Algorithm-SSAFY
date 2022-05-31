package com.ssafy.park;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1956_운동 {
	static int v, e;
    static long[][] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        distance = new long[v + 1][v + 1];

        for (long[] a : distance) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            distance[a][b] = Math.min(distance[a][b], c);
        }

        floydWarshall();

        long answer = Integer.MAX_VALUE;
        for (int i = 1; i <= v; i++) {
            answer = Math.min(answer, distance[i][i]);
        }

        if (answer == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(answer));
        }

        bw.flush();
        br.close();
        bw.close();

    }

    static void floydWarshall() {
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                for (int k = 1; k <= v; k++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
    }
}