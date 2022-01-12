package programmers;

import java.util.*;

public class Heap_디스크컨트롤러 {
    public static void main(String[] args) {
        int[][] jobs={{0,3},{1,9},{2,6}};
        System.out.println(solution(jobs));
    }
    public static class disc implements Comparable<disc>{
        public int start;
        public int time;
        public disc(int start, int time){
            this.start=start;
            this.time=time;
        }
        @Override
        public int compareTo(disc o) {
            return this.start-o.start;
        }
    }
    static class TimeComparator implements Comparator<disc> {
        @Override
        public int compare(disc o1, disc o2) {
            return o1.time - o2.time;
        }
    }
    public static int solution(int[][] jobs) {
        int answer = 0,time=0;
        Queue<disc> pqS = new PriorityQueue<>();
        Queue<disc> pqT = new PriorityQueue<>(new TimeComparator());

        for(int i=0;i<jobs.length;i++){
            pqS.add(new disc(jobs[i][0],jobs[i][1]));
        }

        int curT=0;
        while(!pqS.isEmpty()){
            if(pqS.peek().start<=curT){
                while(!pqS.isEmpty()){
                    if(pqS.peek().start<=curT) pqT.add(pqS.poll());
                    else break;
                }
                if(!pqT.isEmpty()){
                    disc tmp = pqT.poll();
                    answer+=tmp.time+Math.abs(curT- tmp.start);
                    curT+=tmp.time;

                    while(!pqT.isEmpty()) pqS.add(pqT.poll());
                }
            }else{
                curT=pqS.peek().start;
            }
        }
        return answer/ jobs.length;
    }
}
