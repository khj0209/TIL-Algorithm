package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.logging.Handler;

public class BJ_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken()),M=Integer.parseInt(st.nextToken());

        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<N;i++){
            String str = br.readLine();
            map.put(str,1);
        }

        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<M;i++){
            String str=br.readLine();
            if(map.getOrDefault(str,0)==1){
                list.add(str);
            }
        }

        String[] listSort=new String[list.size()];
        for(int i=0;i< list.size();i++){
            listSort[i]=list.get(i);
        }

        System.out.println(listSort.length);
        Arrays.sort(listSort);
        for(String tmp : listSort){
            System.out.println(tmp);
        }
    }
}