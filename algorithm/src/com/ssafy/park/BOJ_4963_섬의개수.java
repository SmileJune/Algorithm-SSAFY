package com.ssafy.park;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {
	static int n;
    static int m;
    static int[][] arr;
    static int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
    static int[] dy = {1, -1, 0, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;
            arr = new int[n][m];
            for (int i = 0; i < m; i++) {
               st = new StringTokenizer(br.readLine()," ");
                for (int j = 0; j < n; j++) {
                    arr[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(island(i, j)) count++;
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
    }

    static boolean island(int x, int y) {
        if(x == -1 || y == -1 || x == n || y == m) return false;
        if(arr[x][y] == 0) return false;

        arr[x][y] = 0;

        for (int i = 0; i < dx.length; i++) {
            int xx = dx[i];
            int yy = dy[i];
            island(x + xx, y + yy);
        }
        return true;
    }
}
