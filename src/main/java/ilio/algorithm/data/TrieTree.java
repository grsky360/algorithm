package ilio.algorithm.data;

/**
 * @author zhongqingyang
 **/
public class TrieTree {

    public final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.links[index] == null) {
                curr.links[index] = new TrieNode();
            }
            curr = curr.links[index];
        }
        curr.end = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.links[index] == null) {
                return false;
            }
            curr = curr.links[index];
        }
        return curr.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (curr.links[index] == null) {
                return false;
            }
            curr = curr.links[index];
        }
        return true;
    }

    public static class TrieNode {
        public final TrieNode[] links = new TrieNode[26];
        public boolean end;
    }

    public static void main(String[] args) {
        TrieTree tree = new TrieTree();
        tree.insert("abcd");
        System.out.println(tree.search("abc"));
        System.out.println(tree.search("abcd"));
        System.out.println(tree.startsWith("abcd"));
        System.out.println(tree.startsWith("abe"));

        System.out.println();
    }
}
