package com.ss.leetcode.LC2022.june;

import com.ss.leetcode.shared.Trie;
import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionsSystem {
    // https://leetcode.com/problems/search-suggestions-system/
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = buildTrie(products);
        List<List<String>> answer = new ArrayList<>(searchWord.length());
        for (int i = 0; i < searchWord.length(); i++) {
            answer.add(getSuggestions(trie, searchWord.substring(0, i + 1)));
        }
        return answer;
    }

    private Trie buildTrie(String[] products) {
        Trie root = new Trie();
        for (String product : products) {
            root.insert(product);
        }
        return root;
    }

    private List<String> getSuggestions(Trie trie, String prefix) {
        List<String> suggestions = new ArrayList<>();
        trie.getListOfSuggestions(prefix, suggestions, 3);
        return suggestions;
    }
}
