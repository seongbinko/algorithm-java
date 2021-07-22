package com.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones_02 {

    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";

        JewelsAndStones_02 jewelsAndStones_02 = new JewelsAndStones_02();
        System.out.println(jewelsAndStones_02.mySolution2(J, S));
    }

    int mySolution(String jewels, String stones) {

        int count = 0;
        for(char jewel : jewels.toCharArray()) {
            for(char stone : stones.toCharArray()) {
                if (jewel == stone) {
                    count ++;
                }
            }
        }
        return count;
    }

    int mySolution2(String jewels, String stones) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for(char jewel : jewels.toCharArray()) {
            set.add(jewel);
        }

        for(char stone : stones.toCharArray()) {
            if(set.contains(stone)) {
                count ++;
            }
        }
        return count;
    }
}
