package com.ssafy.hwang;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Day0603_BOJ_11279 {
    public static void main(String[] args) throws Exception {
        System.out.println(inputData());
    }

    private static String inputData() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        return heapSort(arr);
    }

    private static String heapSort(int[] arr) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0) {
                pq.add(arr[i]);
            } else {
                sb.append(pq.peek() == null ? 0 : pq.poll()).append("\n");
            }
        }
        return sb.toString();
    }
}