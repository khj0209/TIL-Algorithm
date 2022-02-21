package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_5430 {
    static int tc, N;
    static Deque<Integer> dq;
    static String com,arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc=Integer.parseInt(br.readLine());
        here : for(int t=0;t<tc;t++){
            com=br.readLine();
            N=Integer.parseInt(br.readLine());
            dq=new ArrayDeque<>();
            arr=br.readLine();
            arr=arr.substring(1,arr.length()-1);
            StringTokenizer st = new StringTokenizer(arr,",");
            for(int i=0;i<N;i++){
                dq.add(Integer.parseInt(st.nextToken()));
            }

            boolean rev=false;
            for(int i=0;i<com.length();i++){
                if(com.charAt(i)=='R') rev=!rev?true:false;
                else if(dq.isEmpty()){
                    System.out.println("error");
                    continue here;
                }
                else if(!rev) dq.remove();
                else if(rev) dq.removeLast();
            }

            if(!rev){
                System.out.println(dq.toString().replaceAll(" ",""));
            }else {
                StringBuilder sb = new StringBuilder();
                int s=dq.size();
                sb.append("[");
                for(int i=0;i<s;i++){
                    sb.append(dq.pollLast());
                    if(i!=s-1) sb.append(",");
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}
