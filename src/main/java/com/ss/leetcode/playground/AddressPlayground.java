package com.ss.leetcode.playground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class AddressPlayground {
    private static Random rand = new Random();


    public static void main(String[] args) {
        AddressPlayground ap = new AddressPlayground();

        ap.testAddresses();
    }

    public void testAddresses() {
        long now = System.currentTimeMillis();
        Trie trie = new Trie();
        List<Address> addresses = new ArrayList<>(100_000);
        for(int i = 0; i < 100_000; i++) {
            addresses.add(new Address(genRandomString(10), genRandomString(10), genRandomString(10), genRandomString(10),genRandomString(10)));
        }
        long afterCreateList = System.currentTimeMillis();
        addresses.forEach(trie::addAddressToTrie);
//        trie.addAddressToTrie(new Address("abcde", "fghij","klmn","opqr","stuvw"));
        Mapper mapper = new Mapper();
        mapper.addAdddresses(addresses);
        long afterAdding = System.currentTimeMillis();
//        int size1 = trie.findLongestPrefix("ffff").size();
//        int size2 = trie.findLongestPrefix("cd").size();
//        int size3 = trie.findLongestPrefix("q").size();
//        int size4 = trie.findLongestPrefix("vw").size();
//        int size5 = trie.findLongestPrefix("hj").size();
        int size1 = mapper.findLongestPrefix("ffff").size();
//        int size2 = findAnswer("cd", addresses).size();
//        int size3 = findAnswer("q", addresses).size();
//        int size4 = findAnswer("vw", addresses).size();
//        int size5 = findAnswer("hj", addresses).size();
        size1 = mapper.findLongestPrefix("aaa").size();
        int size2 = mapper.findLongestPrefix("bbb").size();
        int size3 = mapper.findLongestPrefix("ccc").size();
        for (int i = 0; i < 5000; i++) {
            findAnswer(genRandomString(4), addresses);
        }
        long afterSearch = System.currentTimeMillis();

        System.out.println("Generating the list took " + (afterCreateList - now) +" ms");
        System.out.println("Adding took " + (afterAdding - afterCreateList) + " ms and searching took " + (afterSearch -  afterAdding) + " ms");

        System.out.println("size 1 = " + size1);
        System.out.println("size 6 = " + size2);
        System.out.println("size 6 = " + size3);
        System.out.println("size 6 = " + size3);
        System.out.println("map size = " + mapper.mappedAddresses.size());
        System.out.println("size 6 = " + size3);
    }

    private List<Address> findAnswer(String search, List<Address> addresses) {
        return addresses.parallelStream().filter(a ->
           a.getCode1().contains(search) || a.getCode2().contains(search) || a.getCode3().contains(search) ||
           a.getCode4().contains(search) || a.getCode5().contains(search)).toList();
    }

    private static String genRandomString(int size) {
        StringBuilder stb = new StringBuilder();
        while(size-- > 0) {
            stb.append((char)(rand.nextInt(26) + 'a'));
        }
        return stb.toString();
    }

    private static class Mapper {
        Map<String, Set<Address>> mappedAddresses;

        public Mapper() {
            mappedAddresses = new HashMap<>(15000000);
        }

        public Set<Address> findLongestPrefix(String str) {
            return mappedAddresses.getOrDefault(str, new HashSet<>());
        }

        public void addAdddresses(List<Address> addresses) {
            addresses.forEach(this::addAddress);
        }

        private void addAddress(Address a) {
            addWord(a.getCode1(), a);
            addWord(a.getCode2(), a);
            addWord(a.getCode3(), a);
            addWord(a.getCode4(), a);
            addWord(a.getCode5(), a);
        }

        private void addWord(String word, Address a) {
            char[] chars =  word.toCharArray();
            StringBuilder stb = new StringBuilder();
            for (int i =0; i < chars.length -3; i++) {
                stb.setLength(0);
                stb.append(chars[i]).append(chars[i+1]);
                for (int j = i + 2; j < chars.length; j++) {
                    stb.append(chars[j]);
                    mappedAddresses.computeIfAbsent(stb.toString(), k -> new HashSet<>()).add(a);
                }
            }
        }

    }

    private static class Address {
        String code1;
        String code2;
        String code3;
        String code4;
        String code5;

        public Address(String code1, String code2, String code3, String code4, String code5) {
            this.code1 = code1;
            this.code2 = code2;
            this.code3 = code3;
            this.code4 = code4;
            this.code5 = code5;
        }

        public String getCode1() {
            return code1;
        }

        public String getCode2() {
            return code2;
        }

        public String getCode3() {
            return code3;
        }

        public String getCode4() {
            return code4;
        }

        public String getCode5() {
            return code5;
        }
    }

    private static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void addAddressToTrie(Address address) {
            addWord(address.getCode1(), address);
            addWord(address.getCode2(), address);
            addWord(address.getCode3(), address);
            addWord(address.getCode4(), address);
            addWord(address.getCode5(), address);
        }

        private void addWord(String word, Address address) {
            for (int i = 0; i < word.length(); i++) {
                addSubstirng(word, i, address);
            }
        }

        private void addSubstirng(String word, int from, Address address) {
            TrieNode first = root, candidate;
            char ch;
            while(from < word.length()) {
                ch = word.charAt(from);
                candidate = first.getNode(ch);
                if (candidate == null) {
                    candidate = first.addNode(ch);
                }
                first = candidate;
                first.addresses.add(address);
                from++;
            }
        }

        public Set<Address> findLongestPrefix(String word) {
            TrieNode first = root, candidate;
            int i = 0;
            char ch;
            while (i < word.length()) {
                ch = word.charAt(i);
                candidate = first.getNode(ch - 'a');
                if (candidate == null) {
                    return new HashSet<>();
                }
                first = candidate;
                i++;
            }
            return new HashSet<>(first.addresses);
        }
    }

    private static class TrieNode {
        Set<Address> addresses;
        Map<Integer, TrieNode> nodes;

        public TrieNode() {
            nodes = new HashMap<>();
            addresses = new HashSet<>();
        }

        public TrieNode getNode(int codePoint) {
            return nodes.get(codePoint);
        }

        public TrieNode addNode(int codePoint) {
            TrieNode newNode = new TrieNode();
            nodes.put(codePoint, newNode);
            return newNode;
        }
    }
}
