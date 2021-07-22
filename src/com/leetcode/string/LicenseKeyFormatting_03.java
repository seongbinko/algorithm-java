package com.leetcode.string;

// https://leetcode.com/problems/license-key-formatting/submissions/
public class LicenseKeyFormatting_03 {

    public static void main(String[] args) {
      String str = "8F3Z-2e-9-wabcdef";
//      String str = "8F3Z-2e-9-w";
//		String str = "8-5g-3-J";
//      String str = "---";
        int k =4;

        LicenseKeyFormatting_03 licenseKeyFormatting_03 = new LicenseKeyFormatting_03();
        System.out.println(licenseKeyFormatting_03.mySolution2(str, k));
    }

    public String mySolution(String s, int k) {
        StringBuilder sb = new StringBuilder();

        int c = 0;
        for(int i = s.length() -1; i >= 0; i--) {

            if(c == k) {
                sb.append('-');
                c = 0;
            }

            char ch = s.charAt(i);
            if(Character.isLetter(ch)) {
                sb.append(Character.toUpperCase(ch));
                c ++;
                continue;
            }
            if('-' == ch) {
                continue;
            }
            sb.append(ch);
            c ++;
        }

        String str = sb.reverse().toString();
        if(str.length() != 0 && str.charAt(0) == '-') {
            str = str.substring(1);
        }

        return str;
    }

    /**
     * 1. - 없애기
     * 2. 대문자로 만들기
     * 3. K = 4로 문자열 나누기
     * 4. 나눈 문자열 사이에 - 넣기
     */
    public String mySolution2(String s, int k) {
        // 1
        String str = s.replace("-", "");
        System.out.println("str = " + str);
        // 2
        str = str.toUpperCase();
        System.out.println("str = " + str);

        // 3

        // 위치에 맞게 -를 넣으려면 StringBuilder 사용하는 것이 편함
        StringBuilder sb = new StringBuilder(str);

        int len = sb.length(); //
        for(int i = k; i < len; i = i + k) {
            sb.insert(len - i, '-');
        }
        return sb.toString();
    }
}
