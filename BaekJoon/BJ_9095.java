package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9095 {
    static int cnt,N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine());
        for(int t=0;t<tc;t++){
            N=Integer.parseInt(br.readLine());
            cnt=0;
            makeN(0);
            System.out.println(cnt);
        }
    }

    private static void makeN(int i) {
        if(i>N) return;
        if(i==N){
            cnt++;
            return;
        }
        makeN(i+1);
        makeN(i+2);
        makeN(i+3);
    }
}
