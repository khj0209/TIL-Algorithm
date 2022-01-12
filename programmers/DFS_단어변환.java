package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class DFS_단어변환 {
    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log","cog"};
        String begin = "hit", target = "cog";

        System.out.println(solution(begin, target, words));
    }

    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    public static int solution(String begin, String target, String[] words) {
        Queue<Integer> q = new LinkedList<>();

        boolean c=false;
        for (int i = 0; i < words.length; i++) {
            if(target.equals(words[i])) c=true;
        }
        if(!c) return 0;

        for (int i = 0; i < words.length; i++) {
            if(check(begin,words[i]))
                q.add(i);
        }

        while(!q.isEmpty()){
            visited=new boolean[words.length];
            int tmp = q.poll();
            visited[tmp]=true;
            DFS(words, target, tmp,1);
        }

        return answer==Integer.MAX_VALUE?0:answer;
    }

    private static boolean check(String begin, String word) {
        int s=0;
        for(int i=0;i<begin.length();i++){
            if(begin.charAt(i)!=word.charAt(i))
                s++;
        }
        return s==1?true:false;
    }

    private static void DFS(String[] words, String target, int tmp, int c) {
        if(c==words.length){
            return;
        }
        if(words[tmp].equals(target)){
            answer=answer<c?answer:c;
            return;
        }
        for(int i=0;i< words.length;i++){
            if(!visited[i] && check(words[tmp],words[i])){
                visited[i]=true;
                DFS(words,target, i,c+1);
                visited[i]=false;
            }
        }
    }
}