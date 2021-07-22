package com.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 고유한 이메일
 * 제한 사항
 *  1 <= emails.length <= 100
 * 1 <= emails[i].length <= 100
 * email[i] consist of lowercase English
 * letters, '+', '.' and '@'.
 * Each emails[i] contains exactly one '@' character.
 * All local and domain names are non-empty.
 * Local names do not start with a '+' character
 *
 * 문제 분석
 * 1. @를 찾아서 로컬이름과 도메인이름으로 나눈다.
 * 2. 로컬이름의 .과 +를 확인하고 원문으로 만든다.
 * 3. 로컬이름과 도메인이름을 합친 것을 Set 자료구조에 담는다
 *
 * 시간 복잡도 O(N)
 * 대상: String[] emails, 문제에서 입력받은 파라미터(array)
 * 이유: for문 한번 실행 O(NM) N= 이메일수, M = Length of email (그리 크지 않다생각)
 *
 * 공간 복잡도 O(N)
 * 대상: Set<String> set; 실제 사용되는 저장공간을 계산
 * https://leetcode.com/problems/unique-email-addresses/
 */
public class UniqueEmailAddress_01 {

    public static void main(String[] args) {

        UniqueEmailAddress_01 uniqueEmailAddress_01 = new UniqueEmailAddress_01();
        String[] emails = {
                "test.e.mail+toto.jane@cod.ing.com",
                "abc@coding.com",
                "testemail+tom@cod.ing.com"
        };
        System.out.println(uniqueEmailAddress_01.mySolution(emails));
    }
    public int mySolution(String[] emails) {
        Set<String> set = new HashSet<>();

        for(String email : emails) {
            set.add(makeLocalName(email) + makeDomainName(email));
        }
        return set.size();
    }

    public String makeLocalName(String email) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i < email.length(); i++) {
            if('.' == email.charAt(i)) {
                continue;
            }
            if('+' == email.charAt(i)) {
                break;
            }
            if('@' == email.charAt(i)) {
                break;
            }
            sb.append(email.charAt(i));
        }
        return sb.toString();
    }
    public String makeDomainName(String email) {
        return email.substring(email.indexOf("@"));
    }


    public int solveSplit(String[] emails) {

        Set<String> set = new HashSet<>();
        for(String email : emails) {
            String[] parts = email.split("@");
            String[] localName = parts[0].split("\\+"); // : Dangling meta character '+' near index 0 +로 하면 컴파일오류가 남
            set.add(localName[0] + "@" + parts[1]);
        }
        return set.size();
    }

    public int solveSubstring(String[] emails) {
        Set<String> set = new HashSet<>();

        for(String email: emails) {
            String localName = email.substring(0, email.indexOf("+")).replace(".", "");
            String domainName = email.substring(email.indexOf("@"));
            set.add(localName + domainName);
        }
        return set.size();
    }
}
