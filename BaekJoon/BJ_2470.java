package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min=Integer.MAX_VALUE;

        int N=Integer.parseInt(st.nextToken());
        int[] num=new int[N];
        int[] answer=new int[2];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        int start=0,end=N-1;

        while(start<end){
            int tmp = num[start]+num[end];

            if(min>Math.abs(tmp)){
                min=Math.abs(tmp);
                answer[0]=num[start];
                answer[1]=num[end];
            }
            if(min==0) break;

            if(tmp<0){
                start++;
            }else end--;

        }

        Arrays.sort(answer);
        System.out.println(answer[0]+" "+answer[1]);
    }
}
