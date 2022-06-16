package LengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xucheng.liu
 * @date 2020/8/10
 */
public class Solution {

    public static void main(String[] args) {

    }

    /**
     * 滑动窗口，左指标右移删除元素，右指标右移添加元素
     * 时间复杂度O(n)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> characters = new HashSet<>();
        int p = 0, q = -1, res = 0;
        for (; p < s.length(); p++) {
            if (p != 0) {
                characters.remove(s.charAt(p - 1));
            }
            while (q + 1 < s.length() && !characters.contains(s.charAt(q + 1))) {
                characters.add(s.charAt(q + 1));
                q++;
            }
            res = Math.max(res, q - p + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstringV2(String s) {
        int res = 0, start = 0, end = 0;
        char character;
        Map<Character, Integer> char2indexMap = new HashMap<>();
        for (; end < s.length(); end++) {
            character = s.charAt(end);
            if (char2indexMap.containsKey(character)) {
                start = Math.max(char2indexMap.get(character), start);
            }
            res = Math.max(res, end - start + 1);
            char2indexMap.put(character, end + 1);
        }
        return res;
    }
}
