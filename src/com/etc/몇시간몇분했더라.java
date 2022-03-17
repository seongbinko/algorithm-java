package com.etc;

/**
 * 현아는 항해에서 한 주 동안 몇 시간 동안 공부했는 지 기록할 수 있는 알고리즘을 만드는데 성공했다.
 * 공부시간을 꼼꼼하게 관리하는 현아는 이번에 분 단위까지 계산할 수 있는 알고리즘을 만들기로 마음을 먹었다.
 *
 * 항해의 체크인 페이지에는 몇가지 조건이 있는데 이를 만족하는 알고리즘을 만들어보자.
 *
 * - 체크아웃을 할 때 익일 시간은 24+a 로 계산한다. 즉 새벽 2시는 24+2 인 26으로 표기한다.
 * - 체크인 페이지는 새벽 5시까지 체크아웃이 되어 있지 않으면 체크아웃을 깜빡한 것으로 간주한다.
 * - 따라서 체크인 시스템은 새벽 5시 정각이나, 새벽 5시를 넘겨서 체크아웃을 하게 되면 자동으로 체크아웃을 오후 9시(21:00)로 한 것으로 처리한다.
 *
 * ### 제한 조건
 *
 * - 체크인(checkin)과 체크아웃(checkout)을 진행한 시간이 담긴 배열 두 개가 주어진다.
 * - 각 배열에는 월요일부터 일요일까지 체크인/아웃을 한 시간이 담겨있다.
 * - checkin과 checkout 배열의 길이는 각각 7 이다.
 * - result는 반드시 “00시간 00분” 형식의 문자열로 출력해주셔야 합니다.
 * ["7:51" ,"8:58", "8:56", "8:35", "9:00", "8:46", "8:56"]	["22:24" ,"21:51", "25:30", "29:10", "29:12", "22:15", "21:31"]
 *  “94시간 29분”
 *
 * ["8:42", "9:00", "8:50", "8:47", "9:01", "8:51", "8:59"]	["21:42", "23:10", "25:30", "29:10", "23:11", "26:44", "29:26"]
 * “100시간 7분”
 *
 *  28:59 ok
 *  5시 이후 부터 체크인이 된다고 가정
 *
 *  배열을 split으로 나눈다.
 */
public class 몇시간몇분했더라 {
    public String solution(String[] arr1, String[] arr2) {
        int totalTime = 0;
        int sixty = 60;

        for (int i = 0; i < 7; i++) {
            String[] beginArr = arr1[i].split(":");
            String[] endArr = arr2[i].split(":");

            if (Integer.parseInt(beginArr[0]) < 5) {
                throw new IllegalArgumentException("올바른 체크인 시간이 아닙니다");
            }
            if (Integer.parseInt(endArr[0]) >= 29) {
                endArr[0] = "21";
                endArr[1] = "00";
            }

            int beginTime = Integer.parseInt(beginArr[0]) * sixty + Integer.parseInt(beginArr[1]);
            int endTime = Integer.parseInt(endArr[0]) * sixty + Integer.parseInt(endArr[1]);
            totalTime += endTime - beginTime;

//            if (beginTime < 5 * sixty) {
//                throw new IllegalArgumentException("올바른 체크인 시간이 아닙니다");
//            }
//
//            if (endTime >= 29 * sixty) {
//                endTime = 21 * sixty;
//            }

//            if (begin.charAt(0) - '0' < 5) {
//                throw new IllegalArgumentException("올바른 체크인 시간이 아닙니다");
//            }
//            if (Integer.parseInt(end.substring(0,2)) > 28) {
//                end = "21:00";
//            }

        }
        int hour = totalTime / sixty;
        int minutes = totalTime % sixty;
        return hour + "시간" + minutes + "분";
//        return new StringBuilder().append(hour).append("시간").append(minutes).append("분").toString();
    }

    public static void main(String[] args) {
        몇시간몇분했더라 method = new 몇시간몇분했더라();
        String[] arr1 = {"7:51" ,"8:58", "8:56", "8:35", "9:00", "8:46", "8:56"};
        String[] arr2 = {"22:24" ,"21:51", "25:30", "29:10", "29:12", "22:15", "21:31"};
        System.out.println(method.solution(arr1, arr2));
    }
}
