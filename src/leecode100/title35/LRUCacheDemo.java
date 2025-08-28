package leecode100.title35;

import java.util.LinkedHashMap;

/**
 * 题目：请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
public class LRUCacheDemo {

    /**
     * 思路：利用LinkedHashMap，底层采用双向链表+哈希表去实现的
     * 删除再插入 就可以改变原有链表数据的顺序
     */
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }

}

class LRUCache {

    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    //如果 key 存在，返回对应的 value，并标记为“最近使用”；否则返回 -1。
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }


    //如果 key 存在，更新 value 并标记为“最近使用”；如果不存在，插入新 key-value 对。如果缓存超过容量，移除最久未使用的项。
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
            return;
        }
        if (cache.size() >= this.cap) {
            int oldKey = cache.keySet().iterator().next(); //取出第一个键  也就是最老的键
            cache.remove(oldKey);
        }
        cache.put(key, value);
    }


    private void makeRecently(int key) {
        Integer val = cache.get(key);
        cache.remove(key); //移除老的值
        cache.put(key,val); //放入新的值
    }
}
