package com.leetcode.graph;

import java.util.*;

public class RemoveInvalidParentheses {

    public static void main(String[] args) {
        String s = "(a)())()";
        RemoveInvalidParentheses a = new RemoveInvalidParentheses();
        System.out.println(a.solve(s));
    }
    public List<String> solve(String s){
        List<String> result = new ArrayList<>();
        if(s==null)
            return result;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        boolean found = false; // bfs는 계속 파고들 것이기 때문에 더이상 파고들지 않게 만드는 장치

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String str = queue.poll();
                if(isValid(str)) { // 쌍이 존재하는지 아닌지 파악하는 함수
                    result.add(str);
                    found = true;
                    System.out.println("str: "+str+" found "+found);
                }
                System.out.println("found "+found);
                if(found) continue;
                for(int j=0; j<str.length(); j++) {
                    if(str.charAt(j)!= '(' && str.charAt(j) !=')') continue;
                    System.out.println(str.substring(0,j)+":"+str.substring(j+1));
                    String newStr = str.substring(0,j)+str.substring(j+1);
                    if(!visited.contains(newStr)) {
//						System.out.println("newStr: "+newStr);
                        queue.offer(newStr);
                        visited.add(newStr);
                    }
                }
                System.out.println("======");
            }
        }
        return result;
    }
    private boolean isValid(String str) {
        int count=0;

        for(char c : str.toCharArray()) {
            if(c=='(') {
                count++;
            }else if(c==')') {
                count--;

                // ())( 위와 같은 케이스는 count는 0이지만 정상적인 케이스가 아니므로 체크 해줘야함
                if(count<0) return false;
            }
        }
        return count==0;
    }

}
