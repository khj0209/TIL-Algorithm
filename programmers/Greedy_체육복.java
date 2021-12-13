package programmers;
import java.util.*;

public class Greedy_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        HashMap<Integer, Boolean> list = new HashMap<>();
        Arrays.sort(lost);

        for(int i=0;i<reserve.length;i++){
            list.put(reserve[i],true);
        }

        for(int i=0;i<lost.length;i++){
            if(list.containsKey(lost[i])){
                list.remove(lost[i]);
                lost[i]=-1;
            }
        }

        for(int i=0;i<lost.length;i++){
            if(lost[i]==-1) continue;

            if(list.containsKey(lost[i]-1)){
                list.remove(lost[i]-1);
                lost[i]=-1;
            }
            else if(list.containsKey(lost[i]+1)){
                list.remove(lost[i]+1);
                lost[i]=-1;
            }
        }

        for(int i=0;i<lost.length;i++){
            if(lost[i]!=-1) answer++;
        }

        return n-answer;
    }
}
