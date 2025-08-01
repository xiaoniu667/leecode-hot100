package leecode100.title12;

import java.util.HashMap;

/*
题目：
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
注意：
对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。

示例 1：
输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。

 */
public class MinCoverSubString {
    /**
     * 思路：利用滑动窗口的机制，向右边扩大窗口直到满足条件，记录答案值，尝试缩小窗口记录最小覆盖的子串。
     */
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = new MinCoverSubString().minWindow(s, t);
        System.out.println(result);
    }

    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        int vaild = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        HashMap<Character, Integer> needMap = new HashMap<>();//记录子串出现的次数
        HashMap<Character, Integer> windowMap = new HashMap<>();//记录滑动窗口中子串出现的次数，需要作比较
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }
        while (right <= s.length() - 1) {
            char c = s.charAt(right);
            right++;
            //查看need中是否需要这个字符串
            if (needMap.containsKey(c)) {
                //如果需要这个字符串，vaild++;
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (windowMap.get(c).equals(needMap.get(c))) {
                    vaild++;
                }
            }
            //满足条件
            while (vaild == needMap.size()) {
                //记录答案值
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                //尝试缩小窗口大小
                char c2 = s.charAt(left);
                left++;
                if (needMap.containsKey(c2)) {
                    if (windowMap.get(c2).equals(needMap.get(c2))) {
                        vaild--;
                    }
                    windowMap.put(c2, windowMap.get(c2) - 1);
                }
            }

        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
