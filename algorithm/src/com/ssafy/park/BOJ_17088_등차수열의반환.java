package com.ssafy.park;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17088_등차수열의반환 {
	static int n, ans = Integer.MAX_VALUE;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();

        bw.write(ans == Integer.MAX_VALUE ? "-1" : String.valueOf(ans));
        bw.close();
        br.close();
    }

    static void solve() {
        if (n == 1) {
            ans = 0;
            return;
        }

        bruteForce(2, arr[1] - 1, (arr[0] - 1) - (arr[1] - 1), 2);
        bruteForce(2, arr[1], (arr[0] - 1) - arr[1], 1);
        bruteForce(2, arr[1] + 1, (arr[0] - 1) - (arr[1] + 1), 2);

        bruteForce(2, arr[1] - 1, arr[0] - (arr[1] - 1), 1);
        bruteForce(2, arr[1], arr[0] - arr[1], 0);
        bruteForce(2, arr[1] + 1, arr[0] - (arr[1] + 1), 1);

        bruteForce(2, arr[1] - 1, (arr[0] + 1) - (arr[1] - 1), 2);
        bruteForce(2, arr[1], (arr[0] + 1) - arr[1], 1);
        bruteForce(2, arr[1] + 1, (arr[0] + 1) - (arr[1] + 1), 2);
    }

    static void bruteForce(int idx, int prev, int diff, int cnt) {
        if (idx == arr.length) {
            ans = Math.min(ans, cnt);
            return;
        }

        if (prev - (arr[idx] - 1) == diff) {
            bruteForce(idx + 1, arr[idx] - 1, diff, cnt + 1);
        }

        if (prev - arr[idx] == diff) {
            bruteForce(idx + 1, arr[idx], diff, cnt);
        }

        if (prev - (arr[idx] + 1) == diff) {
            bruteForce(idx + 1, arr[idx] + 1, diff, cnt + 1);
        }
    }
}

