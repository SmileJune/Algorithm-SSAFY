package com.ssafy.BOJ_SB;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
 
public class BOJ_6588_골드바흐의추측 {
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            solution(n);
 
        }
        System.out.println(sb);
 
    }
 
    public static void solution(int number) {
        for (int i = number; i > 0; i--) {
            if (isPrime(i) == true) {
                int tmp = number - i;
 
                if (isPrime(tmp) == true) {
                    sb.append(number).append(" = ").append(tmp).append(" + ").append(i).append('\n');
                    return;
                }
 
            }
        }
        sb.append("Goldbach's conjecture is wrong.");
        return;
    }
 
    public static boolean isPrime(int number) {
        if (number < 2)
            return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
