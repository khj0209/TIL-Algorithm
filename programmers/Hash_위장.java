package programmers;

import java.util.*;

public class Hash_위장 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> c = new HashMap<>();


        for (int i=0;i<clothes.length;i++) {
            String type = clothes[i][1];
            c.put(type, c.getOrDefault(type, 0) + 1);
        }

        Iterator<Integer> it = c.values().iterator();
        while(it.hasNext()) {
            answer *= it.next().intValue() + 1;
        }

        return answer-1;
    }
}
