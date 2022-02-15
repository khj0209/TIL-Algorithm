package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st1=br.readLine();
        String st2=br.readLine();

        int[][] map = new int[st1.length()+1][st2.length()+1];
        for(int i=0;i<st1.length();i++) map[i][0]=0;
        for(int i=0;i<st2.length();i++) map[0][i]=0;
        int answer=0;

        for(int i=1;i<=st1.length();i++){
            for(int j=1;j<=st2.length();j++){
                if(st1.charAt(i-1)==st2.charAt(j-1)) map[i][j] = map[i-1][j-1]+1;
                else map[i][j]=Math.max(map[i-1][j],map[i][j-1]);
//                if(map[i-1][j]!=0) map[i][j]=map[i-1][j];
//                if(map[i][j-1]!=0) map[i][j]=map[i][j-1];

                answer = answer<map[i][j] ? map[i][j]:answer;
            }
        }

        System.out.println(answer);
    }
}
