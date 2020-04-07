package com.example;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
문제설명
    숫자로 구성된 배열이 있다.
    배열에서 특정구간의 값을 조회해서 정렬했을 때 지정된 순번의 값을 조회하는 프로그램이다.
    src는 숫자를 포함하고 있는 배열이다.
    command는 조회구간과 순번을 포함하고 있는 배열이다.
        {{begin, end, position}, {begin, end, position}, {begin, end, position}}
        begin~end 구간의 값을 src에서 가져온다. 가져온 배열을 오름차순으로 정렬한다. 정렬된 배열에서 position에 해당하는 값을 출력한다.
    예)
        src = {1,5,2,6,3,7,4}
        command = {2,5,3}   // src 배열에서 2번째부터 5번째까지 값을 꺼내서 정렬했을 때 3번째 값을 조회하는 것이다.
        ----> {5,2,6,3} ----> {2,3,5,6} ---> 5

*/
public class Exam05 {
    public static void main(String[] args) {
        int[] src = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};

        for(int[] command : commands) {
            int begin = command[0]-1;
            int end = command[1];
            int position = command[2]-1;
            int length = end - begin;

            int[] dest = new int[length];
            System.arraycopy(src,begin,dest,0,length);
            Arrays.sort(dest);

            int[] answers = Arrays.copyOfRange(src,begin,end);
            Arrays.sort(answers);

            System.out.println(Arrays.toString(command) + " --> " +answers[position]);
            System.out.println(Arrays.toString(command) + " --> " +dest[position]);
        }
    }
}
