package com.ssafy.hong;

import java.io.IOException;
import java.util.*;

public class Boj10745 {
    /**
     * [BOJ: 10745] Censoring
     * 길이 최대 10만인 S 잡지의 text에서
     * N개의 단어들을 모두 제거하라. 단, 제거 후 생기는 지워야 할 단어들도 제거해야 한다.
     * 
     * input:   S     잡지 text
     *          N     지워야 할 단어 수
     *          str1  단어
     *          ..
     * output:  D   모든 단어 제거 후의 문자열
     * @param args
     * @throws IOException
     */
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        Trie root = new Trie();
        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            String D = sc.next();
            root.insert(D);
        }

        setFailure(root);
        Trie curr = root;
        Trie[] tries = new Trie[100002];
        char[] ans = new char[100002];
        int idx=0;
        tries[idx++]=root;
        for(int i=0; i<S.length(); i++){
            char t = S.charAt(i);
            curr = curr.next[t-'a'];

            ans[idx-1]=t;
            tries[idx++]=curr;

            if(curr.finish){
                idx-=curr.length;
                curr=tries[idx-1];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<idx-1; i++) sb.append(ans[i]);
        System.out.println(sb.toString());
    }

    static void setFailure(Trie root){
        Queue<Trie> q = new LinkedList<>();
        q.add(root);
        root.fail=root;

        while(q.size()>0){
            Trie curr = q.poll();

            for(int i=0; i<26; i++){
                Trie next = curr.next[i];
                Trie fail = curr.fail;
                if(next==null)continue;
                if(curr==root)next.fail=root;
                else{
                    while(fail != root && fail.next[i] == null){
                        fail=fail.fail;
                    }
                    if(fail.next[i]!=null)fail=fail.next[i];
                    next.fail=fail;
                }
                if(fail.finish){
                    next.finish=true;
                    next.length=fail.length;
                }
                q.add(next);
            }
        }

        for(int i=0; i<26; i++){
            if(root.next[i] != null) q.add(root.next[i]);
            else root.next[i]=root;
        }
        while(q.size()>0){
            Trie curr = q.poll();

            for(int i=0; i<26; i++){
                if(curr.next[i] != null)q.add(curr.next[i]);
                else curr.next[i]=curr.fail.next[i];
            }
        }
    }


    static class Trie{
        Trie[] next = new Trie[26];
        Trie fail;
        boolean finish;
        int length;

        void insert(String str){
            Trie temp = this;
            for(int i=0; i<str.length(); i++){
                int idx = str.charAt(i)-'a';
                if(temp.next[idx]==null) temp.next[idx]=new Trie();
                temp = temp.next[idx];
            }
            temp.finish=true;
            temp.length=str.length();
        }
    }

}
