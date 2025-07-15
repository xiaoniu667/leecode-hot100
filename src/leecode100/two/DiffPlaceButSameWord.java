package leecode100.two;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 题目：字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 解释：
 * 在 strs 中没有字符串可以通过重新排列来形成 "bat"。
 * 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
 * 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。
 */
public class DiffPlaceButSameWord {
    /**
     * 利用排序将eat->ate tea->ate 可以将他们归为一组
     * 思路：设计一个哈希表 键值对 键使用排序后的单词 值为异位词
     */
    public static void main(String[] args) {
      String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists =
                new DiffPlaceButSameWord().groupAnagrams(strs);
        lists.forEach(System.out::println);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashmap = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            char[] wordCharArray = word.toCharArray();
            Arrays.sort(wordCharArray);
            String key = new String(wordCharArray);
            List<String> defaultList = hashmap.getOrDefault(key, new ArrayList<>());
            defaultList.add(word);
            hashmap.put(key, defaultList);
        }
        return new ArrayList<>(hashmap.values());
    }
}
