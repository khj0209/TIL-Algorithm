package programmers;

public class Greedy_조이스틱 {
    public static void main(String[] args){
        String name="JAN",name2="JEROEN";
        System.out.println(solution(name));
        System.out.println(solution(name2));
    }

    public static int solution(String name) {
        int answer = 0;
        boolean[] isA=new boolean[name.length()];

        for(int i=0;i<name.length();i++){
            char tmp = name.charAt(i);
            if(tmp=='A') isA[i]=true;
            answer+=tmp-'A'>13 ? 'Z'-tmp+1 : tmp-'A';
        }

        answer+=dfs(name, isA,0,0);

        return answer;
    }

    private static int dfs(String name, boolean[] isA, int idx, int move) {
        if(move>name.length()) return move;

        if(!isA[idx]) isA[idx]=true;

        for(int i=0;i<name.length();i++) {
            if (!isA[i]) break;
            if(i==name.length()-1) return move;
        }

        boolean[] clone1=new boolean[isA.length],clone2=new boolean[isA.length];
        for(int i=0;i< isA.length;i++){
            clone1[i] = isA[i];
            clone2[i] = isA[i];
        }

        int right=dfs(name, clone1, idx+1==name.length()?0:idx+1,move+1);
        int left=dfs(name, clone2, idx-1==-1?name.length()-1:idx-1,move+1);

        return Math.min(right,left);
    }
}
