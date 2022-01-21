package com.yang.practice.geek.qinchao.lesson56;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: yangguojun01
 * @Date: 2022/1/21
 */
public class LRUCache<K, V> {

    int capacity;
    // 存放键值对
    Map<K, V> cacheMap;
    // 存放键的队列，最新添加的放队尾
    LinkedList<K> keyQueue;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>(capacity);
        keyQueue = new LinkedList<K>();
    }

    /**
     * 访问元素
     * 元素存在，放到队尾
     */
    public V get(K k) {
        V v = cacheMap.get(k);
        if (v != null) {
            keyQueue.remove(k);
            keyQueue.addLast(k);
        }
        return v;
    }

    /**
     * 添加元素
     * 1.元素存在，删除原值，新值放到队尾
     * 2.不存在，判断链表是否满
     * 如果不满，放入队尾元素，更新哈希表
     * 如果满，则删除队首元素，放入队尾元素，更新哈希表
     */
    public void put(K k, V v) {
        V oldV = cacheMap.get(k);
        if (oldV != null) {
            keyQueue.remove(k);
            keyQueue.addLast(k);
            cacheMap.put(k, v);
            return;
        }
        if (keyQueue.size() < capacity) {
            cacheMap.put(k, v);
            keyQueue.addLast(k);
        } else {
            K firstK = keyQueue.remove();
            cacheMap.remove(firstK);
            cacheMap.put(k, v);
            keyQueue.addLast(k);
        }
    }

}
