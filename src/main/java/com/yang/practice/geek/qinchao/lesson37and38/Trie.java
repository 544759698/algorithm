package com.yang.practice.geek.qinchao.lesson37and38;

import org.apache.commons.lang.StringUtils;

/**
 * 实现一个字典树
 *
 * @Author: yangguojun01
 * @Date: 2022/1/7
 */
public class Trie {

    TrieNode root = new TrieNode(' ');

    public void insert(String word) {
        if (StringUtils.isEmpty(word)) {
            return;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
        }
        // 结束标记，这里不能少！！！
        node.isEnd = true;
    }

    public boolean search(String word) {
        if (StringUtils.isEmpty(word)) {
            return true;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isEnd;
    }

    public boolean startWith(String prefix) {
        if (StringUtils.isEmpty(prefix)) {
            return true;
        }
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }

}

class TrieNode {
    char val;
    boolean isEnd;
    TrieNode[] children = new TrieNode[26];

    public TrieNode(char val) {
        this.val = val;
        isEnd = false;
    }
}
