package week05code.daily;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Gamigo
 * @version 1.0
 * @date 2020-05-20 16:40
 */
public class WordLadder {

    private int length;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        if(n == 0) {
            return 0;
        }
        length = beginWord.length();
        boolean[] marked = new boolean[n];
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        while(!queue.isEmpty()){
            Pair<String, Integer> temp = queue.remove();
            for(int i = 0; i < n; i++){
                String next = wordList.get(i);
                if(!marked[i] && canTransform(temp.getKey(), next)){
                    if(next.equals(endWord))
                        return temp.getValue() + 1;
                    marked[i] = true;
                    queue.add(new Pair<>(wordList.get(i), temp.getValue() + 1));
                }
            }
        }
        return 0;
    }

    private boolean canTransform(String from, String to){
        int count = 0;
        for(int i = 0; i < length; i++){
            if(from.charAt(i) != to.charAt(i)){
                if(count == 1)
                    return false;
                else count++;
            }
        }
        return true;
    }
}
