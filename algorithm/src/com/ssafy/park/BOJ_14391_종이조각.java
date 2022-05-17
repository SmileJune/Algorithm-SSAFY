package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14391_종이조각 {
	static int n, m, answer = 0;
    static int[] map;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n * m];
        map = new int[n * m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i * m + j] = input.charAt(j)-'0';
            }
        }

        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int idx) {
        if (idx == n * m) {
            check();
            return;
        }

  
        visit[idx] = true;
        dfs(idx + 1);
        visit[idx] = false;

        dfs(idx + 1);
    }

    static void check() {
        int sum = 0, tmp = 0;

        for (int i = 0; i < n; i++) {
            tmp = 0;
            for (int j = 0; j < m; j++) {
                if (visit[i * m + j]) {
                    tmp *= 10;
                    tmp += map[i * m + j];
                } else {
                    sum += tmp;
                    tmp = 0;
                }
            }
            sum += tmp;
        }
        for (int j = 0; j < m; j++) {
            tmp = 0;
            for (int i = 0; i < n; i++) {
                if (!visit[i * m + j]) {
                    tmp *= 10;
                    tmp += map[i * m + j];
                } else {
                    sum += tmp;
                    tmp = 0;
                }
            }
            sum += tmp;
        }

        answer = Math.max(answer, sum);
    }
}