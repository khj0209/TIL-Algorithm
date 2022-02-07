package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_7662_이중우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스 반복
        int tc=Integer.parseInt(br.readLine());
        for(int i=0;i<tc;i++) {
            // 입력할 명령어 갯수
            int N = Integer.parseInt(br.readLine());
            Map<Integer, Integer> m = new HashMap<>();
            PriorityQueue<Integer> minq = new PriorityQueue<>();
            PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());

            //명령어 입력
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                // 숫자 추가
                if (command.equals("I")) {
                    minq.add(num);
                    maxq.add(num);
                    m.put(num, m.getOrDefault(num, 0) + 1);
                }
                // 숫자 삭제
                else if (command.equals("D")) {
                    // 최대값 삭제
                    if (num == 1) {
                        while(true) {
                            if (maxq.isEmpty()) break;
                            int t = maxq.poll();

                            if (m.getOrDefault(t, 0) > 1) {
                                m.put(t, m.get(t) - 1);
                                break;
                            } else if(m.getOrDefault(t, 0) == 1) {
                                m.remove(t);
                                break;
                            }
                        }
                    }
                    //최소값 삭제
                    else if(num==-1){
                        while(true) {
                            if (minq.isEmpty()) break;
                            int t = minq.poll();

                            if (m.getOrDefault(t, 0) > 1) {
                                m.put(t, m.get(t) - 1);
                                break;
                            } else if(m.getOrDefault(t, 0) == 1) {
                                m.remove(t);
                                break;
                            }
                        }
                    }
                    // 삭제 했는데 map에 값이 없다면 추가되었던 모든 수가 삭제된 상황이므로 큐도 다 비워준다 (필수는 아님)
                    if(m.size()==0){
                        maxq.clear();
                        minq.clear();
                    }
                }
            }

            //map 사이즈가 0이면 비어있으므로 출력
            if (m.size() == 0) System.out.println("EMPTY");
            //각 큐에는 아직 처리되지 않은 수들이 섞여있으므로 그걸 제거해줌
            else {
                int minS=minq.size(),maxS=maxq.size();
                for(int s=0;s<minS;s++){
                    if(minq.isEmpty()) break;
                    int t = minq.peek();

                    if(m.getOrDefault(t,0)==0) minq.poll();
                    else break;
                }
                for(int s=0;s<maxS;s++) {
                    if(maxq.isEmpty()) break;
                    int t = maxq.peek();

                    if(m.getOrDefault(t,0)==0) maxq.poll();
                    else break;
                }
                System.out.println(maxq.poll()+" "+minq.poll());
            }
        }
    }
}
