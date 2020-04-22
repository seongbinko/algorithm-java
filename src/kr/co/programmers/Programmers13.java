package kr.co.programmers;

import java.util.*;

public class Programmers13 {

    public static void main(String[] args) {
        int[] answers = {1,2,3,5,4,1,3};
        int[] p1s = {1,2,3,4,5};
        int[] p2s = {2,1,2,3,2,4,2,5};
        int[] p3s = {3,3,1,1,2,2,4,4,5,5};

        int check = 0;

        int size = 0;
        int size2 = 0;



        List<Integer> list =  new ArrayList<Integer>();

        int c1 = 0;
        int c2 = 0;
        int c3 = 0;

        for(int answer : answers) {
            size = answers.length/p1s.length;
            size2 = answers.length%p1s.length;
            if(size == 0) {
                for(int i=0; i<answers.length; i++) {
                    if(answer == p1s[i]) {
                        c1 ++;
                    }
                }
            } else {
                while(check != size) {
                    for (int p1 : p1s) {
                        list.add(p1);
                    }
                    check++;
                }
                if(size2 != 0) {
                    for(int i=0; i<size2; i++) {
                        list.add(p1s[i]);
                    }
                }
                for(int lis : list) {
                    if(answer == lis) {
                        c1 ++;
                    }
                }
                list.clear();
                check = 0;
            }
        }
        for(int answer : answers) {
            size = answers.length/p2s.length;
            size2 = answers.length%p2s.length;
            if(size == 0) {
                for(int i=0; i<answers.length; i++) {
                    if(answer == p2s[i]) {
                        c2 ++;
                    }
                }
            } else {
                while(check != size) {
                    for (int p2 : p2s) {
                        list.add(p2);
                    }
                    check++;
                }
                if(size2 != 0) {
                    for(int i=0; i<size2; i++) {
                        list.add(p2s[i]);
                    }
                }
                for(int lis : list) {
                    if(answer == lis) {
                        c2 ++;
                    }
                }
                list.clear();
                check = 0;
            }
        }
        for(int answer : answers) {
            size = answers.length/p3s.length;
            size2 = answers.length%p3s.length;
            if(size == 0) {
                for(int i=0; i<answers.length; i++) {
                    if(answer == p3s[i]) {
                        c3 ++;
                    }
                }
            } else {
                while(check != size) {
                    for (int p3 : p3s) {
                        list.add(p3);
                    }
                    check++;
                }
                if(size2 != 0) {
                    for(int i=0; i<size2; i++) {
                        list.add(p3s[i]);
                    }
                }
                for(int lis : list) {
                    if(answer == lis) {
                        c3 ++;
                    }
                }
                list.clear();
                check = 0;
            }
        }
        int[] answer;
        if (c1 >= c2 && c1 >= c3) {
             //answer = c1;
        } else if (c2 >= c1 && c2 >= c3) {
            //answer = c2;
        } else {
            //answer = c3;
        }
    }
}
