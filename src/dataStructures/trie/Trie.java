package dataStructures.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private static class TrieNode {
        private boolean isEnd = false;
        private Map<Character, TrieNode> children = new HashMap<>();

        public boolean isEnd() {
            return isEnd;
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public void setChildren(Map<Character, TrieNode> children) {
            this.children = children;
        }
    }
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            if(current.getChildren().get(c) == null)
                current.getChildren().put(c, new TrieNode());
            current = current.getChildren().get(c);
        }
        current.setEnd(true);
    }

    public boolean search(String word) {
        TrieNode node = searchHelper(word);
        return node != null && node.isEnd();
    }

    private TrieNode searchHelper(String prefix) {
        TrieNode current = root;
        for(char c : prefix.toCharArray()) {
            if(current.getChildren().get(c) == null)
                return null;
            current = current.getChildren().get(c);
        }
        return current;
    }
}
