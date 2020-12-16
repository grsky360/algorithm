package ilio.algorithm.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhongqingyang
 * @url https://leetcode-cn.com/problems/accounts-merge/
 **/
public class AccountsMerge {

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFinder finder = new UnionFinder(5000);
        Map<String, String> emailNameMap = new HashMap<>();
        return accounts;
    }

    private static class UnionFinder {
        private final int[] parent;
        public UnionFinder(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int getParent(int x) {
            if (parent[x] == x) {
                return x;
            }
            return (parent[x] = getParent(parent[x]));
        }

        public void union(int x, int y) {
            parent[getParent(x)] = getParent(y);
        }
    }

    public static void main(String[] args) {
        List<List<String>> accounts = Arrays.asList(
            Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
            Arrays.asList("John", "johnnybravo@mail.com"),
            Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
            Arrays.asList("Mary", "mary@mail.com")
        );
        System.out.println(accountsMerge(accounts));
    }
}
