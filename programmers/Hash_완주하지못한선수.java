package programmers;
import java.util.*;

public class Hash_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> p = new HashMap<>();

        for(int i=0;i<participant.length;i++){
            if(p.containsKey(participant[i])){
                p.replace(participant[i],p.get(participant[i])+1);
            }
            else p.put(participant[i],1);
        }

        for(int i=0;i<completion.length;i++){
            if(p.get(completion[i])==1){
                p.remove(completion[i]);
            }
            else p.replace(completion[i],p.get(completion[i])-1);
        }

        Iterator<String> iter = p.keySet().iterator();
        answer = iter.next();

        return answer;
    }
}
