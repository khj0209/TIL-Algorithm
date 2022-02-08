package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_17626 {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp=new int[N+1];

        for(int i=1;i<=N;i++){
            int tmp;
            if(Math.sqrt(i)!=Double.NaN) {
                tmp=(int)Math.sqrt(i);
                if(tmp*tmp==i) {
                    dp[i] = 1;
                    continue;
                }
                else{
                    findMin(i);
                }
            }
        }
        System.out.println(dp[N]);
    }

    private static void findMin(int num) {
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=num/2;i++){
            int tmp = dp[i]+dp[num-i];
            min=min>tmp?tmp:min;
        }
        dp[num]=min;
    }
}
