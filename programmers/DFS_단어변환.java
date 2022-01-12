package programmers;

public class DFS_단어변환 {
    static boolean[] visited;

    public static void main(String[] args){
        String[] words={"hot", "dot", "dog", "lot", "log"};
        String begin="hit", target="cog";

        System.out.println(solution(begin, target, words));
    }

    static int min=Integer.MAX_VALUE;
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;

        for(int i=0;i< words.length;i++){
            visited=new boolean[words.length];
            if(isPossible(begin, words[i])) {
                visited[i]=true;
                dfs(1, i, target, words);
            }
        }
        answer=min==Integer.MAX_VALUE?0:min;

        return answer;
    }

    public static void dfs(int deps, int idx, String target, String[] words){
        if(idx==words.length) return;

        for(int i=0;i< words.length;i++) {
            if (isPossible(words[idx], words[i]) && !visited[i]) {
                visited[i]=true;
                dfs(deps+1, i, target, words);
            }
        }
    }

    public static boolean isPossible(String begin, String word) {
        int comlen=0;
        for(int i=0;i<begin.length();i++){
            if(begin.charAt(i)!=word.charAt(i)) comlen++;
        }
        return comlen==1?true:false;
    }
}
//if(isPossible(words[idx],target)){
//    min=min<deps+1?min:deps+1;
//    return;
//}