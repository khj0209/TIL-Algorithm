package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_18870 {
    static class X implements Comparable<X> {
        int index;
        int num;
        int zip;
        X(int index,int num){
            this.index=index;
            this.num=num;
        }
        @Override
        public int compareTo(X o) {
            return this.num-o.num;
        }
        public int compareToIndex(X o) {
            return this.index-o.index;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        ArrayList<X> list=new ArrayList<>();

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            list.add(new X(i,Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);

        int cnt=-1,tmp=Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            if(list.get(i).num!=tmp){
                cnt++;
                list.get(i).zip=cnt;
                tmp=list.get(i).num;
            }else {
                list.get(i).zip=cnt;
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(list,X::compareToIndex);
        for(int i=0;i<N;i++){
            sb.append(list.get(i).zip+" ");
//            System.out.print(list.get(i).zip + " ");
        }
        System.out.println(sb);
    }
}
