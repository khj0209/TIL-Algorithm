package programmers.Level2;

import java.util.HashMap;

public class Test4 {
    public static void main(String[] args) {
        String[][] relation={{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

        System.out.println(solution(relation));
    }
    public static int solution(String[][] relation) {
        int answer = 0;
        HashMap<String,Integer> m = new HashMap<>();

        for(int i=0;i<relation.length;i++){
            for(int j=0;j<relation[i].length;j++){
                if(m.get(relation[i][j])!=null) {
                    break;
                }
                else if(i==relation[i].length-1){
                    answer++;
                }
                else{
                    m.put(relation[i][j], 1);
                }
            }

        }

        return answer;
    }
}
