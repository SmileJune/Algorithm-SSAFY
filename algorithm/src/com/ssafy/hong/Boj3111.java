package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj3111 {
    /**
     * [BOJ: 3111] 검열
     * 신문 T에 A라는 단어 제거한다.
     * 1.T에 A가 없으면 종료
     * 2.T에 처음 등장하는 A 제거
     * 3.T에 A가 없으면 종료
     * 4.T에 마지막으로 등장하는 A 제거
     * 5.1로 돌아감
     *
     * input:   str1    제거하는 단어
     *          str2    신문
     * output:  ans     제거된 결과
     * @param args
     */
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        String src = sc.nextLine();
        String dst = sc.nextLine();
        int N=src.length(), M=dst.length();
        int i=0, j=M-1;
        boolean isFirst=true;
        List<Character> front = new ArrayList<>();
        List<Character> back = new ArrayList<>();

        while(i<=j){
            if(isFirst) {
                front.add(dst.charAt(i++));
                int size = front.size();
                if(size >= N){
                    boolean flag= true;
                    for(int k=size-N, l=0; k<size; k++){
                        if(src.charAt(l++)!=front.get(k)){
                            flag=false;
                            break;
                        }
                    }
                    if(flag){
                        for(int k=0; k<N; k++)front.remove(front.size()-1);
                        isFirst=!isFirst;
                    }
                }
            }
            else{
                back.add(dst.charAt(j--));
                int size = back.size();
                if(size >= N){
                    boolean flag= true;
                    for(int k=size-1, l=0; k>=size-N; k--){
                        if(src.charAt(l++)!=back.get(k)){
                            flag=false;
                            break;
                        }
                    }
                    if(flag){
                        for(int k=0; k<N; k++)back.remove(back.size()-1);
                        isFirst=!isFirst;
                    }
                }
            }
        }
        int idx=back.size()-1;
        while(idx>=0){
            front.add(back.get(idx--));
            int size= front.size();
            if(size >= N){
                boolean flag= true;
                for(int k=size-N, l=0; k<size; k++){
                    if(src.charAt(l++)!=front.get(k)){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    for(int k=0; k<N; k++)front.remove(front.size()-1);
                }
            }
        }
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
        for(char c : front)br.append(c);
        br.flush();
    }

}
