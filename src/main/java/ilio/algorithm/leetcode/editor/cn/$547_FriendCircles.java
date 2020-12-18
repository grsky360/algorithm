package ilio.algorithm.leetcode.editor.cn;

import ilio.algorithm.data.*;

import java.util.*;
import java.util.stream.IntStream;

//班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 
//的朋友。所谓的朋友圈，是指所有朋友的集合。 
//
// 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你
//必须输出所有学生中的已知的朋友圈总数。 
//
// 
//
// 示例 1： 
//
// 输入：
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//输出：2 
//解释：已知学生 0 和学生 1 互为朋友，他们在一个朋友圈。
//第2个学生自己在一个朋友圈。所以返回 2 。
// 
//
// 示例 2： 
//
// 输入：
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//输出：1
//解释：已知学生 0 和学生 1 互为朋友，学生 1 和学生 2 互为朋友，所以学生 0 和学生 2 也是朋友，所以他们三个在一个朋友圈，返回 1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 200 
// M[i][i] == 1 
// M[i][j] == M[j][i] 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 385 👎 0


public class $547_FriendCircles {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] M) {
        UF uf = new UF(M.length);
        int res = M.length;
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1 && uf.union(i, j)) {
                    res--;
                }
            }
        }
        return res;
    }

    public static class UF {
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
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.findCircleNum(new int[][]{
//            {1,1,0},
//            {1,1,0},
//            {0,0,1}
//        })); // 2
//
//        System.out.println(solution.findCircleNum(new int[][]{
//            {1,1,0},
//            {1,1,1},
//            {0,1,1}
//        })); // 1

        System.out.println(solution.findCircleNum(new int[][]{
            {1,1,1},
            {1,1,1},
            {1,1,1}
        })); // 1
    }
}
