package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Stack_Queue_주식가격 {
    public static void main(String[] args){
        int[] prices={1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));
    }
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0;i<prices.length;i++){
            int t=0;
            for(int j=i;j<prices.length-1;j++){
                if(prices[i]>prices[j]){
                    answer[i]=t;
                    break;
                }else if(j==prices.length-2) answer[i]=++t;
                t++;
            }
        }

        return answer;
    }
}
