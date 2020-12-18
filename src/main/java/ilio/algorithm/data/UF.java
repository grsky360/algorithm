package ilio.algorithm.data;

import java.util.Arrays;

/**
 * @author zhongqingyang
 **/
public class UF {

    private final int[] parent;

    public UF(int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);
    }

    public int find(int k) {
        return parent[k] == k || parent[k] == -1 ? k : (parent[k] = find(parent[k]));
    }

    public boolean union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        parent[fx] = fy;
        return fx != fy;
    }
}
