package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Stack_Queue_다리를지나는트럭 {
    public static void main(String[] args){
        int[] truck_weights={10,10,10,10,10,10,10,10,10,10};
        int bridge_length=100,weight=100;

        System.out.println(solution(bridge_length,weight,truck_weights));

        int[] truck_weights2={7,4,5,6};
        int bridge_length2=2,weight2=10;

        System.out.println(solution(bridge_length2,weight2,truck_weights2));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0,input_idx=0,onBridge_weight=0;
        Queue<Integer> bridge = new LinkedList<>();

        while(true){
            if(onBridge_weight+truck_weights[input_idx] <= weight) {
                onBridge_weight+=truck_weights[input_idx];
                bridge.add(truck_weights[input_idx++]);
            }
            else
                bridge.add(0);

            if(input_idx == truck_weights.length) {
                answer += bridge_length+1;
                break;
            }

            int tmp=-1;
            if(bridge.size()>=bridge_length){
                onBridge_weight-=bridge.poll();
            }

            answer++;
        }

        return answer;
    }
}
