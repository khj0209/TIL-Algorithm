package programmers;

import java.util.*;

public class Hash_베스트앨범 {
    public static void main(String[] args){
        String[] genres={"classic", "pop", "classic", "classic", "pop"};
        int[] plays={500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public static class Song implements Comparable<Song> {
        public int num,play;
        public String genre;

        public Song(String genre, int play, int num){
            this.num=num;
            this.play=play;
            this.genre=genre;
        }

        @Override
        public int compareTo(Song o) {
            return o.play-play==0 ? num-o.num : o.play-play;
        }
    }
    public static class genreC implements Comparable<genreC>{
        public int playCount;
        public String name;
        public genreC(String name, int playCount){
            this.name=name;
            this.playCount=playCount;
        }
        @Override
        public int compareTo(genreC o) {
            return o.playCount-playCount;
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int answerSize=0;
        HashMap<String, Integer> gCount = new HashMap<>();
        HashMap<String, Integer> gPlay = new HashMap<>();

        //1. 속한 노래의 플레이수가 더 많은 장르 순
        //2. 장르에서 플레이수가 더 많은 노래 순
        //3. 같은 플레이수라면 넘버가 더 작은거

        Song[] list = new Song[genres.length];
        ArrayList<genreC> glist = new ArrayList<>();

        for(int i=0;i< list.length;i++) {
            int gc = gCount.get(genres[i])==null ?  0 : gCount.get(genres[i]);
            if (gc==0) {
                gCount.put(genres[i], 1);
                glist.add(new genreC(genres[i],plays[i]));
                answerSize++;
            } else if(gc==1) {
                gCount.put(genres[i], 2);
                for(int j=0;j<glist.size();j++){
                    if(glist.get(j).name.equals(genres[i])){
                        int tmp = glist.get(j).playCount;
                        glist.remove(j);
                        glist.add(new genreC(genres[i],tmp+plays[i]));
                        break;
                    }
                }
                answerSize++;
            } else {
                for(int j=0;j<glist.size();j++){
                    if(glist.get(j).name.equals(genres[i])){
                        int tmp = glist.get(j).playCount;
                        glist.remove(j);
                        glist.add(new genreC(genres[i],tmp+plays[i]));
                        break;
                    }
                }
            }
            list[i] = new Song(genres[i], plays[i], i);
        }
        Collections.sort(glist);

        Song[] ans = new Song[answerSize];
        int ansIdx=0;

        Arrays.sort(list);
        for(int i=0;i< list.length;i++){
            if(gCount.get(list[i].genre)>0){
                gCount.put(list[i].genre,gCount.get(list[i].genre)-1);
                int gp = gPlay.get(list[i].genre)==null ?  0 : gPlay.get(list[i].genre);
                gPlay.put(list[i].genre,gp+list[i].play);
                ans[ansIdx++]=list[i];
            }
        }
        Arrays.sort(ans);

        answer=new int[answerSize];
        int answeridx=0;

        for(int i=0;i<glist.size();i++) {
            for(int j=0;j<ans.length;j++){
                if(glist.get(i).name.equals(ans[j].genre)){
                    answer[answeridx++]=ans[j].num;
                }
            }
        }
        return answer;
    }
}
