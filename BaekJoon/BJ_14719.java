package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H=Integer.parseInt(st.nextToken()),W=Integer.parseInt(st.nextToken());
        boolean[][] block = new boolean[H][W];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<W;i++){
            int b=Integer.parseInt(st.nextToken());
            for(int j=0;j<b;j++){
                block[H-j-1][i]=true;
            }
        }

        int answer=0;
        for (int i=0;i<H;i++){
            boolean check=false;
            int water=0;
            for(int j=0;j<W;j++){
                if(block[i][j] && !check) check=true;
                else if(block[i][j] && check) {
                    answer+=water;
                    water=0;
                }
                else if(!block[i][j] && check) water++;
            }
        }
        System.out.println(answer);
    }
}
