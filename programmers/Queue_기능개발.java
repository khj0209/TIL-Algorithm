package programmers;

import java.util.*;

public class Queue_기능개발 {
    public static void main(String[] args){
        int[] progresses={95, 90, 99, 99, 80, 99};
        int[] speeds={1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(progresses,speeds)));

        int[] progresses2={93,30,55};
        int[] speeds2={1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses2,speeds2)));
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        List<Integer> a = new ArrayList<>();
        int[] days=new int[progresses.length];
        Queue<Integer> q = new LinkedList<>();


        for(int i=0;i< progresses.length;i++){
            days[i]=(100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]>0) days[i]++;
        }
        for(int day : days){
            q.add(day);
        }

        while(!q.isEmpty()){
            int i = q.poll();
            int cnt=1;
            if(q.isEmpty()) a.add(cnt);
            for(;!q.isEmpty();){
                if(q.peek()<=i) {
                    q.poll();
                    cnt++;
                    if(q.isEmpty()) a.add(cnt);
                }else if(q.peek()>i){
                    a.add(cnt);
                    break;
                }
            }
        }

        answer=new int[a.size()];
        for(int i=0;i<a.size();i++){
            answer[i]=a.get(i);
        }

        return answer;
    }
}
