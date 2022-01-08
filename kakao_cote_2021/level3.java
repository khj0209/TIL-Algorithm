package kakao_cote_2021;

import java.util.ArrayList;
import java.util.Stack;

public class level3 {
    public static void main(String[] args){
        int n=8,k=2;
        String[] cmd={"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        String[] cmd2={"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};

        System.out.println(solution(n,k,cmd));
        System.out.println(solution(n,k,cmd2));
    }
    static ArrayList<Integer> list;
    public static String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        boolean[] l = new boolean[n];
        Stack<Integer> del = new Stack<>();
        list = new ArrayList<>();

        for(int i=0;i<n;i++) list.add(i);

        for(int i=0;i<cmd.length;i++){
            if(cmd[i].charAt(0)=='U'){
                k-=Character.getNumericValue(cmd[i].charAt(2));
            }else if(cmd[i].charAt(0)=='D'){
                k+=Character.getNumericValue(cmd[i].charAt(2));
            }else if(cmd[i].charAt(0)=='C'){
                del.push(list.get(k));
                list.remove(k);
                if(k==list.size()) k--;
            }else{
                int tmp = del.pop();

                if(tmp<list.get(k)){
                    addList(tmp);
                    k++;
                }
                else addList(tmp);
            }
        }
        for(int i=0;i< list.size();i++){
            l[list.get(i)]=true;
        }

        for(int i=0;i<n;i++){
            if(l[i]) answer.append("O");
            else answer.append("X");
        }

        return answer.toString();
    }

    private static void addList(int tmp) {
        if(tmp<list.get(0)) {
            list.add(0,tmp);
            return;
        }else if(list.get(list.size()-1)<tmp){
            list.add(tmp);
            return;
        }
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)<tmp && tmp<list.get(i+1)){
                list.add(i+1,tmp);
                return;
            }
        }
    }
}
