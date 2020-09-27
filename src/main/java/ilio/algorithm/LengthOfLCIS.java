package leetcode;

public class LengthOfLCIS {

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 0, crr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] > nums[i - 1]) {
                crr++;
            } else {
                res = Math.max(crr, res);
                crr = 1;
            }
        }
        return Math.max(crr, res);
    }

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{3,0,6,2,4,7,0,0}));
    }
}
