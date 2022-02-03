package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_2407 {
    static BigInteger[] fact;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        fact=new BigInteger[n+1];
//        n!/m!*(n-m)!
        fact[1]=BigInteger.valueOf(1);

        fact();
        System.out.println(fact[n].divide(fact[m].multiply(fact[n-m])));
    }

    private static void fact() {
        for(int i=2;i<=n;i++){
            fact[i]=fact[i-1].multiply(BigInteger.valueOf(i));
        }
    }
}
