package kr.co.programmers;

import java.util.Arrays;
//완주하지 못한선수 hash
public class Programmers10 {
    //2차
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        System.out.println(solution(participant,completion));
        System.out.println(solution2(participant,completion));
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
        String[] comp = Arrays.copyOf(completion,completion.length+1);
        comp[completion.length] = "";

        String answer = "";

        for (int i=0; i<participant.length; i++){
            if(!comp[i].equals(participant[i])) {
                answer = participant[i];
                break;
            }
        }
        return answer;
    }
}
