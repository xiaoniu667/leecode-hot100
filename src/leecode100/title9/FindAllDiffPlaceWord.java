package leecode100.title9;

import java.util.*;

/**
 * 题目：
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 */
public class FindAllDiffPlaceWord {

    /**
     * 思路:滑动窗口思想。固定一个大小为p长度的窗口，不断移动，
     * 计算窗口中字符出现的频次与p中字符频次是否相同，如果相同就是异位词，反之，则不是。
     */

    public static void main(String[] args) {
        String s = "baa";
        String p = "aa";
        List<Integer> list = new FindAllDiffPlaceWord().findAnagrams(s, p);
        list.forEach(System.out::println);
    }

    public List<Integer> findAnagrams(String s, String p) {
        int left = 0;
        int right = p.length() - left - 1;
        HashMap<Character, Integer> hashMap = new HashMap<>(); //记录频次
        HashMap<Character, Integer> pHashMap = new HashMap<>();    //记录p字符串出现的频次
        for (int i = 0; i < p.length(); i++) {
            pHashMap.put(p.charAt(i), pHashMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        while (right <= s.length() - 1) {
            for (int i = left; i <= right; i++) {
                hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
            }
            //对比hashmap和p之间出现的频次
            int count = 0;
            Set<Character> characters = pHashMap.keySet();
            for (Character character : characters) {
                if (hashMap.getOrDefault(character, 0).equals(pHashMap.get(character))) {
                    count++;
                }
            }
            if (count == pHashMap.size()) {
                resultList.add(left);
            }
            hashMap = new HashMap<>();
            left++;
            right++;
        }
        return resultList;
    }
}
