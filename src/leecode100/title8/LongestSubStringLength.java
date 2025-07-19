package leecode100.title8;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 题目：给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LongestSubStringLength {

    /**
     * 思路：利用滑动窗口的思路，利用双指针，left和right指针。
     * 利用hashmap存储子串，移动right的指针，尝试包含多个字符，如果不重复，更新最大子串
     * 长度，如果重复，移动left指针，同时从hashmap中去掉重复字母之前的所有字符。
     */
    public static void main(String[] args) {
        String s = "pwwkew";
        int result = new LongestSubStringLength().lenghOfLongestSubstring(s);
        System.out.println(result);
    }

    public int lenghOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int maxLength = 0;
        HashMap<Integer, Character> hashmap = new HashMap<>();
        while (right <= s.length() - 1) {
            char c = s.charAt(right);
            while (hashmap.containsValue(c)) {
                hashmap.remove(left);
                left++;
            }
            hashmap.put(right, c);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

}
