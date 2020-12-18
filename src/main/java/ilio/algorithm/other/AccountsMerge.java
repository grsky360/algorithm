package ilio.algorithm.other;

import org.checkerframework.checker.units.qual.C;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author zhongqingyang
 * @url https://leetcode-cn.com/problems/accounts-merge/
 **/
public class AccountsMerge {

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFinder unionFinder = new UnionFinder((int) accounts.stream().flatMap(List::stream).count());
        Map<String, String> emailNameMap = new HashMap<>();
        Map<String, Integer> emailIndexMap = new HashMap<>();
        int index = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailNameMap.put(email, name);
                if (!emailIndexMap.containsKey(email)) {
                    emailIndexMap.put(email, index++);
                }
                if (i != 1) {
                    unionFinder.union(emailIndexMap.get(account.get(1)), emailIndexMap.get(email));
                }
            }
        }
        Map<Integer, List<String>> result = new HashMap<>();
        emailNameMap.forEach((email, name) -> {
            result.computeIfAbsent(unionFinder.getParent(emailIndexMap.get(email)), k -> new ArrayList<>()).add(email);
        });
        result.forEach((id, emails) -> {
            emails.sort(Comparator.naturalOrder());
            emails.add(0, emailNameMap.get(emails.get(0)));
        });
        return new ArrayList<>(result.values());
    }

    private static class UnionFinder {
        private final int[] parent;
        public UnionFinder(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);
        }
        public int getParent(int k) {
            if (parent[k] == k || parent[k] == -1) {
                return k;
            }
            return (parent[k] = getParent(parent[k]));
        }

        public void union(int x, int y) {
            parent[getParent(y)] = getParent(x);
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
