package com.ssafy.hwang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Day38_BOJ_A더하기B9 {
    public static void main(String args[]) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] input =br.readLine().split(" ");
        BigInteger a =new BigInteger(input[0]);
        BigInteger b =new BigInteger(input[1]);
        System.out.print((a.add(b)).toString());
    }
}