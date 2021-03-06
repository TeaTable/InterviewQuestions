/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

public class Solution1 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int N = s.length();
        boolean[][] isMatch = new boolean[N+1][N+1];
        isMatch[0][0] = true;
        for (int i = 1; i <= N; i++) {
            for (int j = i - 1; !isMatch[0][i] && j >= 0; j--) {
                isMatch[0][i] = (wordDict.contains(s.substring(j, i)) && isMatch[0][j]);
            }
        }
        return isMatch[0][N];
    }
}

public class Solution2 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int N = s.length();
        boolean[] isMatch = new boolean[N+1];
        isMatch[0] = true;
        for (int i = 1; i <= N; i++) {
            for (int j = i - 1; !isMatch[i] && j >= 0; j--) {
                isMatch[i] = (wordDict.contains(s.substring(j, i)) && isMatch[j]);
            }
        }
        return isMatch[N];
    }
}

public class Solution3 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        Queue<Integer> queue = new LinkedList<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (!visited.contains(index)) {
                visited.add(index);
                for (int i = index + 1; i <= s.length(); i++) {
                    if (wordDict.contains(s.substring(index, i))) {
                        if (i == s.length()) {
                            return true;
                        }
                        queue.add(i);
                    }
                }
            }
        }
        return false;
    }
}
