package ilio.algorithm.node;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author zhongqingyang
 * @url https://leetcode-cn.com/problems/sum-of-distances-in-tree/
 **/
public class SumOfDistancesInTree {

    public static int[] sumOfDistancesInTree(int N, int[][] edges) {
        if (N == 0 || edges.length == 0 || edges[0].length == 0) {
            return new int[N];
        }
        List<List<Integer>> graph = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }
        int[] counts = new int[N];
        int[] nodes = new int[N];
        Arrays.fill(nodes, 1);
        postOrder(0, 0, counts, nodes, graph);
        preOrder(0, 0, counts, nodes, graph);
        return counts;
    }

    private static void postOrder(int parent, int grand, int[] counts, int[] nodes, List<List<Integer>> graphs) {
        List<Integer> childs = graphs.get(parent);
        for (Integer child : childs) {
            if (child == grand) {
                continue;
            }
            postOrder(child, parent, counts, nodes, graphs);
            nodes[parent] += nodes[child];
            counts[parent] += counts[child] + nodes[child];
        }
    }

    private static void preOrder(int parent, int grand, int[] counts, int[] nodes, List<List<Integer>> graphs) {
        List<Integer> childs = graphs.get(parent);
        for (Integer child : childs) {
            if (child == grand) {
                continue;
            }
            counts[child] = counts[parent] - nodes[child] + (counts.length - nodes[child]);
            preOrder(child, parent, counts, nodes, graphs);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}})));
        System.out.println(Arrays.toString(sumOfDistancesInTree(7, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}, {3, 6}})));
    }
}
