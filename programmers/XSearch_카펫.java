package programmers;

import java.util.Arrays;

public class XSearch_카펫 {
    public static void main(String[] args) {
        int brown=10,yello=2;

        System.out.println(Arrays.toString(solution(brown, yello)));

    }public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int n=brown+yellow;

        for(int i=1;i<n;i++){
            if(n%i==0) {
                int w=n/i;
                if(2*w+2*i-4==brown){
                    answer[0]=w;
                    answer[1]=i;
                    break;
                }
            }
        }

        //brown=2w+2h-4
        //yellow=wh-brown

        return answer;
    }
}
