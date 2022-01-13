package programmers;

import java.util.Arrays;

public class Sort_HIndex {
    public static void main(String[] args) {
        int[] citations={3, 0, 6, 1, 5};

        System.out.println(solution(citations));
    }
    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=1;i<citations[citations.length-1];i++){
            int cnt=0;
            for(int j=0;j<citations.length;j++){
                if(citations[j]>=i) cnt++;
            }
            if(i<=cnt && citations.length-cnt<=i) answer=i;
        }
        return answer;
    }
}
