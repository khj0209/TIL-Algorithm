package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12865 {
//    static class Things implements Comparable<Things>{
//        int weight;
//        int value;
//        public Things(int weight,int value){
//            this.weight=weight;
//            this.value=value;
//        }
//
//        @Override
//        public int compareTo(Things o) {
//            return o.weight-this.weight;
//        }
//    }
    static int N,max,maxV=0;
    static int[][] list,dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        max=Integer.parseInt(st.nextToken());
        list=new int[N+1][2];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int weight=Integer.parseInt(st.nextToken());
            int value =Integer.parseInt(st.nextToken());

            list[i][0]=weight;
            list[i][1]=value;
        }

        dp=new int[N+1][100001];
        for(int n=1;n<=N;n++){
            for(int w=1;w<=max;w++){
                if(list[n][0]<=w){
                    if(list[n][1]+dp[n-1][w-list[n][0]]>dp[n-1][w]){
                        dp[n][w] = list[n][1] + dp[n-1][w-list[n][0]];
                    }else dp[n][w]=dp[n-1][w];
                }else{
                    dp[n][w]=dp[n-1][w];
                }
            }
        }

        System.out.println(dp[N][max]);
    }
}
