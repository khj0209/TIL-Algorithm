package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                s.push(num);
            }else if(command.equals("pop")){
                if(s.isEmpty()) sb.append(-1+"\n");
                else sb.append(s.pop()+"\n");

            }else if(command.equals("size")){
                sb.append(s.size()+"\n");
            }else if(command.equals("empty")){
                if(s.isEmpty()) sb.append(1+"\n");
                else sb.append(0+"\n");
            }else if(command.equals("top")){
                if(s.isEmpty()) sb.append(-1+"\n");
                else sb.append(s.peek()+"\n");
            }
        }
        System.out.println(sb);
    }
}
