package com.ssafy.hong;
import java.io.*;
import java.util.*;

public class Boj1874 {
	/**
     * [BOJ: 1874] 스택 수열
     * 1~n까지 수를 스택에 넣었다가 뽑으면서 수열을 만들 수 있다.
     * 임의의 수열이 주어질 때 위 과정을 통해 만들 수 있는지 확인
     * 만들 수 있다면 push =>'+', pop=>'-' 과정을 한줄에 하나씩 출력
     * 없다면 "NO" 출력
     * 
     * input:   N   수열의 길이
     *          a   수열
     *          ..
     * output:  ans 만들 수 있으면 1줄당 push,pop 과정, 없다면 "NO"
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> s = new Stack<>();
        boolean flag = true;
        char[] ans = new char[200001];
        int t = 1, idx = 0;
        for(int i=0; i<N; i++){
            int n = sc.nextInt();
            while(t<=n){
                ans[idx++]='+';
                s.push(t++);
            }
            if(s.peek()==n){
                ans[idx++]='-';
                s.pop();
            }
            else{
                flag=false;
                break;
            }
        }
        if(flag){
            for(int i=0; i<idx; i++) System.out.println(ans[i]);
        }
        else{
            System.out.println("NO");
        }
    }
}
