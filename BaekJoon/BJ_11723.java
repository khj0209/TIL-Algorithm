package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N=Integer.parseInt(st.nextToken());
        int bit=0;

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            String command=st.nextToken();
            if(command.equals("all")){
                bit=1048495;
                continue;
            }else if(command.equals("empty")){
                bit=0;
                continue;
            }

            int num = Integer.parseInt(st.nextToken())-1;

            if(command.equals("add")){
                if((bit & (1<<num))==0) bit|=(1<<num);
            }else if(command.equals("remove")){
                if((bit & (1<<num))==(1<<num)) bit-=(1<<num);
            }else if(command.equals("check")){
                if((bit & (1<<num))==0) sb.append("0\n");
                else sb.append("1\n");
            }else if(command.equals("toggle")){
                if((bit & (1<<num))==0) bit|=(1<<num);
                else bit-=(1<<num);
            }
        }
        System.out.println(sb);
    }
}