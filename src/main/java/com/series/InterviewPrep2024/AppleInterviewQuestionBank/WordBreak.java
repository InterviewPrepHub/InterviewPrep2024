package com.series.InterviewPrep2024.AppleInterviewQuestionBank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] wordBreakTracker = new boolean[s.length()+1];
        wordBreakTracker[0] = true;

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {
                if(wordBreakTracker[j] && wordDictSet.contains(s.substring(j,i))) {
                    wordBreakTracker[i] = true;
                    break;
                }
            }
            
        }
        return wordBreakTracker[s.length()];
    }

    public static void main(String[] args) {

        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");

        WordBreak w = new WordBreak();
        System.out.println(w.wordBreak(s, wordDict));
    }
}
