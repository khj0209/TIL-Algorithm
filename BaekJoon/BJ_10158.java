package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10158 {
    static int w,h,p,q,n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w =Integer.parseInt(st.nextToken());
        h=Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        p =Integer.parseInt(st.nextToken());
        q=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(br.readLine());

        int answerp=p+n,answerq=q+n;
        if((answerp/w)%2==0){
            answerp=answerp%w;
        }else{
            answerp=w-(answerp%w);
        }

        if((answerq/h)%2==0){
            answerq=answerq%h;
        }else{
            answerq=h-(answerq%h);
        }
        System.out.print(answerp);
        System.out.print(" ");
        System.out.print(answerq);
    }
}