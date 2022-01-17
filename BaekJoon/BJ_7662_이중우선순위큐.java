package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_7662_이중우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc=Integer.parseInt(br.readLine());
        for(int i=0;i<tc;i++){
            int[] answer = {0,0};
            int N=Integer.parseInt(br.readLine());
            Map<Integer,Integer> m = new HashMap<>();
            PriorityQueue<Integer> minq = new PriorityQueue<>();
            PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());

            for(int j=0;j<N;j++){
                String tmp = br.readLine();

                if(tmp.charAt(0)=='I'){
                    int num=Integer.parseInt(tmp.substring(2,tmp.length()));
                    minq.add(num);
                    maxq.add(num);
                    m.put(num,m.getOrDefault(num,0)+1);
                }

                else if(tmp.equals("D 1")){
                    if(maxq.isEmpty()) continue;
                    while(true) {
                        if(maxq.isEmpty() || m.size()==0) break;
                        int t = maxq.poll();

                        if(m.getOrDefault(t,0)>1){
                            m.put(t,m.getOrDefault(t,0)-1);
                            break;
                        }else if(m.getOrDefault(t,0)==1){
                            m.remove(t);
                            break;
                        }
                    }
                }

                else if(tmp.equals("D -1")){
                    if(minq.isEmpty()) continue;
                    while(true) {
                        if(minq.isEmpty() || m.size()==0) break;
                        int t = minq.poll();

                        if(m.getOrDefault(t,0)>1){
                            m.put(t,m.get(t)-1);
                            break;
                        }else if(m.getOrDefault(t,0)==1){
                            m.remove(t);
                            break;
                        }
                    }
                }
            }


            if(m.size()==0)
                System.out.println("EMPTY");
            else if(m.size()==1) {
                int min=0,max=0;
                while(true) {
                    if(minq.isEmpty()) break;
                    int t = minq.peek();

                    if(m.getOrDefault(t,0)>=1){
                        min=t;
                        max=t;
                        break;
                    }else{
                        minq.poll();
                    }
                }
                while(true) {
                    if(maxq.isEmpty()) break;
                    int t = maxq.peek();

                    if(m.getOrDefault(t,0)>=1){
                        min=t;
                        max=t;
                        break;
                    }else{
                        maxq.poll();
                    }
                }
                System.out.println(max+" "+min);
            }
            else System.out.println(maxq.poll()+" "+minq.poll());
        }
    }
}
