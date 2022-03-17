package com.etc;


/**
 * 문제
 * CS 스터디 팀장이 된 지용이는 팀원들의 연락처를 수집하여 정리하는 도중 문제 하나를 발견했다.
 * 지용이는 팀원들에게 전화번호를 ‘010-1234-4567’ 양식으로 제출하기를 부탁했지만 ‘01012345678’과 같이 ‘-’ 구분 없이 붙여서 제출한 사람들의 전화번호가 엑셀에서 앞에 0이 사라진 ‘1012345678’로 보이는 것이다.
 * 지용이는 ‘1012345678’로 저장된 전화번호를 다시 ‘010-1234-5678’ 형식으로 바꾸려고 한다.
 * 지용이를 도와줄 수 있는 알고리즘을 만들어 보자
 *
 * 제한조건
 * phone은 length는 10으로 고정됩니다.
 *
 * 입출력 예
 * “10 1234 5678”	-> “010-1234-5678”
 * 0을 가지고 있는 StringBuilder 만들기
 * i 2, 6 번째의 수  + 왼쪽에 - 붙이기
 *
 */

public class 전화번호양식 {
    public String solution(String phone) {
        StringBuilder sb = new StringBuilder("0");
        for (int i = 0; i < phone.length(); i++) {
            if (i == 2 || i == 6) {
                sb.append("-").append(phone.charAt(i));
            } else {
                sb.append(phone.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        전화번호양식 method = new 전화번호양식();
        System.out.println(method.solution("1099620331"));
    }
}
