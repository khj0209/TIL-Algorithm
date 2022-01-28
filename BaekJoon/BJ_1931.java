package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1931 {
    static class Time implements Comparable<Time>{
        int start;
        int end;
        Time(int start, int end){
            this.start=start;
            this.end=end;
        }

        @Override
        public int compareTo(Time o) {
            if(this.end==o.end)
                return this.start-o.start;
            return this.end-o.end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        Time[] list=new Time[N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            list[i]=new Time(start,end);
        }
        Arrays.sort(list);

        int endT=0,cnt=0;
        for(int i=0;i<N;i++){
            if(list[i].start>=endT){
                cnt++;
                endT=list[i].end;
            }
        }

        System.out.println(cnt);
    }
}