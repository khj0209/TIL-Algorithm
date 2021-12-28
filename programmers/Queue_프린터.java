package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_프린터 {
    public static void main(String[] args){
        int[] priorities={2, 1, 3, 2};
        int location=2;

        System.out.println(solution(priorities, location));

        int[] priorities2={1, 1, 9, 1, 1, 1};
        int location2=0;

        System.out.println(solution(priorities2, location2));
    }

    public static class docs{
        int prop;
        int idx;
        public docs(int prop, int idx){
            this.prop=prop;
            this.idx=idx;
        }
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<docs> q = new LinkedList<>();
        for(int i=0;i< priorities.length;i++){
            q.add(new docs(priorities[i], i));
        }

        while(!q.isEmpty()){
            boolean isAgain=false;
            docs t = q.poll();
            Queue<docs> tmpQ = new LinkedList<>();

            while(!q.isEmpty()){
                if(t.prop<q.peek().prop){
                    isAgain=true;
                    break;
                }else{
                    tmpQ.add(q.poll());
                }
            }

            if(isAgain) {
                q.add(t);
                while(!tmpQ.isEmpty())
                    q.add(tmpQ.poll());
            }
            else if(!isAgain && t.idx==location) return ++answer;
            else {
                while(!tmpQ.isEmpty())
                    q.add(tmpQ.poll());
                answer++;
            }
        }
        return answer;
    }
}
