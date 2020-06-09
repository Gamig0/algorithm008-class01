package week07code.daily;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-07 21:02
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = wordList.size();
        if (length == 0 || !wordList.contains(endWord)) {
            return 0;
        }
        int step = 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        boolean[] visited = new boolean[wordList.size()];
        while (!q.isEmpty()) {
            int n = q.size();
            step++;
            for (int i = 0; i < n; ++i) {
                String current = q.poll();
                for (int j = 0; j < visited.length; ++j) {
                    if (visited[j] || !canTransfor(current, wordList.get(j))) {
                        continue;
                    }
                    if (wordList.get(j).equals(endWord)) {
                        return step + 1;
                    }
                    q.add(wordList.get(j));
                    visited[j] = true;
                }
            }
        }
        return 0;
    }
    public boolean canTransfor(String current, String next) {
        int count = 0;
        for (int i = 0, len = current.length(); i < len; ++i) {
            if (count > 1) {
                return false;
            }
            if (current.charAt(i) != next.charAt(i)) {
                count++;
            }
        }
        return count == 1 ? true : false;
    }
}
