package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Heap_더맵게 {
    public static void main(String[] args){
        int[] scoville={1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville,K));
    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> scov = new PriorityQueue<>();
        for(int i : scoville)
            scov.add(i);

        while(scov.peek()<K){
            int tmp = scov.poll(), tmp2 = scov.poll();
            int mix = tmp+(tmp2*2);
            scov.add(mix);
            answer++;
            if(scov.poll()>=K) break;
            if(scov.size()<2){
                answer=-1;
                break;
            }
        }

        return answer;
    }
}
