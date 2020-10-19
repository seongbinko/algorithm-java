package kr.co.programmers;

import java.util.Arrays;
import java.util.HashMap;
//완주하지 못한선수 hash
public class Programmers10 {
    //2차
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        System.out.println(solution(participant, completion));
        System.out.println(solution2(participant, completion));
        // 10월 19일 추가 테스트 통과 하지 못함
        System.out.println(solution3(participant, completion));
    }
    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for (i=0; i<completion.length; i++){
            if(!completion[i].equals(participant[i])) {
                break;

            }
        }
        return participant[i];
    }
    // 1차
    public static String solution2(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        String[] comp = Arrays.copyOf(completion, completion.length + 1);
        comp[completion.length] = "";

        String answer = "";

        for (int i = 0; i < participant.length; i++) {
            if (!comp[i].equals(participant[i])) {
                answer = participant[i];
                break;
            }
        }
        return answer;
    }

    public static String solution3(String[] participant, String[] completion) {
        String answer = "";

        HashMap<Integer, String> hmap = new HashMap<>(participant.length);
        for (int i = 0; i < participant.length; i++) {
            hmap.put(i, participant[i]);
        }

        for (int i = 0; i < completion.length; i++) {
            for (int j = 0; j < participant.length; j++) {
                if (completion[i].equals(participant[j])) {
                    hmap.remove(j);
                    break;
                }
            }
        }
        for (Integer key : hmap.keySet()) {
            answer = hmap.get(key);
        }
        return answer;
    }
}
