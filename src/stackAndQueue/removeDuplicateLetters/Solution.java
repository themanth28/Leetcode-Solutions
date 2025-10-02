package stackAndQueue.removeDuplicateLetters;

import java.util.*;

public class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> lastOccurence = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            lastOccurence.put(s.charAt(i), i);
        }

        Stack<Character> st = new Stack<>();
        Set<Character> visited = new HashSet<>();

        for(int i=0; i<s.length(); i++){
            if(visited.contains(s.charAt(i))){
                continue;
            }
            
            while(!st.isEmpty() && s.charAt(i) < st.peek() 
                && i < lastOccurence.getOrDefault(st.peek(), -1)){
                    visited.remove(st.pop());
                }

            st.push(s.charAt(i));
            visited.add(s.charAt(i));

        }
        
            StringBuilder str = new StringBuilder();

            for(char ch : st){
                str.append(ch);
            }

            return str.toString();
    }
}