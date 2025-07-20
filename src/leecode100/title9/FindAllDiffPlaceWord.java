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
     * 用什么来存储字符的频次呢，可以用hashmap但是时间复杂度过大，可以直接用数组，利用随机存取的特性降低时间复杂度。
     * 两个数组 snum和pnum 先存放第一组数据，进行比较，后续遍历进行滑动窗口，移除窗口最左端字符，添加窗口最右端字符，然后进行比较。
     */

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> list = new FindAllDiffPlaceWord().findAnagrams(s, p);
        list.forEach(System.out::println);
    }


    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (s.length() < p.length()) return resultList;//边界判断
        int[] snum = new int[26];
        int[] pnum = new int[26];
        //进行第一组数据的存放
        for (int i = 0; i < p.length(); i++) {
            snum[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < p.length(); i++) {
            pnum[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(snum, pnum)) {
            resultList.add(0);
        }
        //进行滑动窗口
        for (int i = p.length(); i <= s.length() - 1; i = i + 1) {
            //移除窗口最左端字符
            snum[s.charAt(i - p.length()) - 'a']--;
            //添加窗口最右端字符
            snum[s.charAt(i) - 'a']++;
            if (Arrays.equals(snum, pnum)) {
                resultList.add(i - p.length() + 1);
            }
        }
        return resultList;
    }


//    public List<Integer> findAnagrams(String s, String p) {
//        int left = 0;
//        int right = p.length() - left - 1;
//        HashMap<Character, Integer> hashMap = new HashMap<>(); //记录频次
//        HashMap<Character, Integer> pHashMap = new HashMap<>();    //记录p字符串出现的频次
//        for (int i = 0; i < p.length(); i++) {
//            pHashMap.put(p.charAt(i), pHashMap.getOrDefault(p.charAt(i), 0) + 1);
//        }
//
//        ArrayList<Integer> resultList = new ArrayList<>();
//        while (right <= s.length() - 1) {
//            for (int i = left; i <= right; i++) {
//                hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
//            }
//            //对比hashmap和p之间出现的频次
//            int count = 0;
//            Set<Character> characters = pHashMap.keySet();
//            for (Character character : characters) {
//                if (hashMap.getOrDefault(character, 0).equals(pHashMap.get(character))) {
//                    count++;
//                }
//            }
//            if (count == pHashMap.size()) {
//                resultList.add(left);
//            }
//            hashMap = new HashMap<>();
//            left++;
//            right++;
//        }
//        return resultList;
//    }
}
