package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_12026 {
    static int N,idx=0;
    static int[] dp;
    static char[] list={'B','O','J'};
    static String street;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        street = br.readLine();
        dp=new int[N];
        Arrays.fill(dp,987654321);

        jump();
        System.out.println(dp[N-1]==Integer.MAX_VALUE?-1:dp[N-1]);
    }

    private static void jump() {
        dp[0]=0;
        for(int i=0;i<N-1;i++){
            char now=street.charAt(i);
            int nextIdx=findIdx(now);
            for(int j=i+1;j<N;j++){
                if(street.charAt(j)==list[nextIdx]){
                    dp[j]=Math.min(dp[j],dp[i]+(j-i)*(j-i));
                }
            }
        }
    }

    private static int findIdx(char now) {
        int re=0;
        for(int i=0;i<3;i++){
            if(now==list[i]) {
                re=i;
                break;
            }
        }
        return (re+1)%3;
    }
}