package com.ssafy.hong;
import java.io.*;
import java.util.*;

public class Boj1918 {

	/**
	 * [BOJ: 1918] 후위 표기식
	 * 중위 표현을 후위표현식으로 바꾸기
	 * 피 연산자는 'A'~'Z'로 각 1번씩만 나옴
	 * 연산자로 /,*,-,+ 나옴
	 * 괄호는 (,)만 나옴
	 * input:  str    계산식
	 * output: ans	  후위 표기
	 */
    static Map<Character, Integer> priority = new HashMap<>();
    static{
        priority.put('-',2);priority.put('+',2);
        priority.put('*',1);priority.put('/',1);
        priority.put('(',0);
    }
    static Stack<String> num = new Stack<>();
    static Stack<Character> op = new Stack<>();
    public static void main(String[] args) throws IOException {
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c>='A' && c<='Z')num.push(str.substring(i,i+1));
            else if(c==')'){
                while(!op.isEmpty() && op.peek()!='('){
                    calc();
                }
                if(op.peek()=='(')op.pop();
            }
            else{
                while(!op.isEmpty() && priority.get(c) >= priority.get(op.peek()) && op.peek()!='('){
                    calc();
                }
                op.push(c);
            }
        }
        while(!calc()){
            if(op.peek()=='(')op.pop();
        }
        bw.append(num.pop());
        bw.flush();
    }

    static boolean calc(){
        while(!op.isEmpty()){
            char c = op.peek();
            if(c=='(')return false;
            op.pop();
            String str1 = num.pop();
            String str2 = num.pop();
            num.push(str2+str1+c);
            if(!op.isEmpty() && priority.get(op.peek()) != priority.get(c))return false;
        }
        return true;
    }

}
