package com.my.java;

import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;

import java.util.Collection;

/**
 * @Description TODO
 * @Author xusucheng
 * @Date 2024/4/23
 */
public class TrieTest {
    public static void main(String[] args) {
        /*String inputString = "hello there, william";
        String[] words = {"hello", "william"};

        Trie trie = Trie.builder().onlyWholeWords().addKeywords(words).build();
        Collection<Emit> emits = trie.parseText(inputString);
        emits.forEach(System.out::println);*/


        Trie trie = Trie.builder()
//                .ignoreOverlaps()
                .addKeyword("hot")
                .addKeyword("hot chocolate")
                .build();
        Collection<Emit> emits = trie.parseText("hot chocolate");
        emits.forEach(System.out::println);
    }
}
