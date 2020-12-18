package ilio.algorithm.leetcode.editor.cn;

import ilio.algorithm.data.*;

import java.util.*;

//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。 
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 相邻的孩子中，评分高的孩子必须获得更多的糖果。 
// 
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？ 
//
// 示例 1: 
//
// 输入: [1,0,2]
//输出: 5
//解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2: 
//
// 输入: [1,2,2]
//输出: 4
//解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。 
// Related Topics 贪心算法 
// 👍 317 👎 0


public class $135_Candy {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        return candy1(ratings);
    }

    private int candy1(int[] ratings) {
        int left = 0;
        int right = 0;
        int res = 0;
        boolean prevUp = false;
        boolean prevDown = false;
        for (int i = 1; i < ratings.length; i++) {
            boolean up = ratings[i] > ratings[i - 1];
            boolean down = ratings[i] < ratings[i - 1];
            boolean flat = ratings[i] == ratings[i - 1];

            if ((prevUp && flat) || (prevDown && (up || flat))) {
                res += Math.max(left, right) + calc(left) + calc(right);
                left = 0;
                right = 0;
            }

            if (up) {
                left++;
            } else if (down) {
                right++;
            } else {
                res++;
            }

            prevUp = up;
            prevDown = down;
        }
        res += Math.max(left, right) + 1 + calc(left) + calc(right);
        return res;
    }

    private int calc(int n) {
        return n * (n + 1) / 2;
    }

    private int candy2(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int res = candies[candies.length - 1];
        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            res += candies[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[]{1, 0, 1}));
    }
}
