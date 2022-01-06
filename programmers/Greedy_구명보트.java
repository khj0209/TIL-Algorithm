package programmers;

import java.util.Arrays;
import java.util.Collections;

public class Greedy_구명보트 {
    public static void main(String[] args){
        int[] people= {70, 50, 80, 50};
        int limit =100;

        System.out.println(solution(people, limit));
    }
    public static int solution(int[] people, int limit) {
        int answer = 0;
        int[] person = new int[241];

        for(int i : people) person[i]++;

        for(int i=0;i<people.length;i++){
            person[people[i]]--;
            for(int j=limit-people[i];j>0;j--){
                if(person[j]>0){
                    person[j]--;
                    answer++;
                    break;
                }
                if(j==1) answer++;
            }
        }
        return answer;
    }
}
