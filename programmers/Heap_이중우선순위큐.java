package programmers;

import java.util.*;

public class Heap_이중우선순위큐 {
    public static void main(String[] args) {
        String[] operations={"I 7","I 5","I -5","I -7","D -1"};
        String[] operations2={"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations3={"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
//        System.out.println(Arrays.toString(solution(operations)));
//        System.out.println(Arrays.toString(solution(operations2)));
        System.out.println(Arrays.toString(solution(operations3)));
    }
    public static int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> q = new PriorityQueue<>();
        PriorityQueue<Integer> mq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<operations.length;i++){
            if(operations[i].charAt(0)=='I'){
                int tmp=Integer.parseInt(operations[i].substring(2,operations[i].length()));
                if(tmp>=0) q.add(tmp);
                else mq.add(tmp);
            }
            else if(operations[i].equals("D 1")){
                Queue<Integer> tmpq=new LinkedList<>();
                if(!q.isEmpty()) {
                    int qSize=q.size();
                    for(int j=1;j<qSize;j++) tmpq.add(q.poll());
                    q.poll();
                    for(int j=1;j<qSize;j++) q.add(tmpq.poll());
                }
                else if(!mq.isEmpty()) {
                    mq.poll();
                }

            }
            else if(operations[i].equals("D -1")){
                Queue<Integer> tmpq=new LinkedList<>();
                if(!mq.isEmpty()) {
                    int qSize=mq.size();
                    for(int j=1;j<qSize;j++) tmpq.add(mq.poll());
                    mq.poll();
                    for(int j=1;j<qSize;j++) mq.add(tmpq.poll());
                }
                else if(!q.isEmpty()) {
                    q.poll();
                }
            }
        }

        if(mq.isEmpty() && q.isEmpty()) {
            answer[0]=0;
            answer[1]=0;
            return answer;
        }

        //최솟값
        if(mq.isEmpty()) answer[1]=q.poll(); //음수가없다면 양수중 제일 작은값
        else { //음수가있다면 다빼고 마지막꺼
            int qSize=mq.size();
            for(int j=1;j<qSize;j++) mq.poll();
            answer[1]=mq.poll();
        }

        //최대값
        if(!q.isEmpty()) { //양수가 있다면
            int qSize=q.size();
            for(int j=1;j<qSize;j++) q.poll();
            answer[0]=q.poll();
        }
        else answer[0]=mq.poll();

        return answer;
    }
}
