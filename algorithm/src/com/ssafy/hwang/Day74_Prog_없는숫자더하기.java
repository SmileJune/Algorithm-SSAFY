package com.ssafy.hwang;

class Solution {
    public int solution(int[] numbers) {
        int answer = -1;
        int sum=0;
        for(int i =0; i<=9;i++){
            sum+=i;
        }
        for(int i =0; i<numbers.length;i++){
            sum -= numbers[i];
        }
        answer=sum;
        
        return answer;
    }
}
