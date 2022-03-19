package com.ssafy.namja;

import java.util.Scanner;

public class Main {
    static int[] heap;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        heap = new int[N * N + 1];
        
        for (int i = 0; i < N * N; i++) {
            push(sc.nextInt());
        }
        
        int ans = 0;
        for (int i = 0; i < N; i++)
            ans = pop();
        
        System.out.println(ans);
    }
    
    static void push(int item) {
        int i = ++n;
        
        while((i != 1) && (item > heap[i / 2])) {
            heap[i] = heap[i / 2];
            i = i / 2;
        }
        heap[i] = item;
    }
    static int pop() {
        int first, temp, parent, child;
        first = heap[1];
        temp = heap[n--];
        
        parent = 1;
        child = 2;
        
        while(child <= n) {
            if (heap[child] <= heap[child + 1])
                child++;
            if (heap[child] <= temp)
                break;
            
            heap[parent] = heap[child];
            parent = child;
            child = child * 2;
        }
        heap[parent] = temp;
        return first;
    }
}
