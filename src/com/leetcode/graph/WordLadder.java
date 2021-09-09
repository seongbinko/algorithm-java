package com.leetcode.graph;

import java.util.*;

/**
 * 단어 사다리
 * https://leetcode.com/problems/word-ladder/
 * bfs 유형
 */
public class WordLadder {
    public static void main(String[] args) {
        String[] words = {"hot","dot","lot","log","cog"};
//		String[] words = {"hot","dot","dog","lot","log"};
        List<String> wordList = Arrays.asList(words);
//		Set<String> dict = new HashSet<>(wordList);
        WordLadder a = new WordLadder();
        System.out.println(a.ladderLength_neighbor("hit","cog", wordList));
    }

    private int ladderLength_neighbor(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || !wordList.contains(endWord))
            return 0;

        Queue<String> q = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);
        q.offer(beginWord);
        dict.add(endWord); // 중복 코드
        dict.remove(beginWord);
        int level = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i < size; i++) {
                String str = q.poll(); // hit
                if(str.equals(endWord)) {
                    return level;
                }
                for(String neighbor : neighbors(str, dict)) {
                    q.offer(neighbor);
                }
            }
            level++;
        }

        return 0;
    }
    public List<String> neighbors(String s, Set<String> dict) {
        List<String> res = new LinkedList<>();
//        Set<String> dict = new HashSet<>(wordList); 이 식으로 하면 시간 초과 뜸

        for(int i=0; i<s.length(); i++) {
            char[] chars = s.toCharArray();
            for(char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch; // ait ~ zit
                String word = new String(chars);
                if(dict.remove(word)) { // 해당하는 단어가 있다면
                    res.add(word);
                }
            }
        }
        return res;
    }
}
