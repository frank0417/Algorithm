import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    /*
     * 题 目：滑动窗口最大值
     * 链 接：https://leetcode-cn.com/problems/sliding-window-maximum/
     * 描 述：给你一个整数数组 nums，有一个大小为  k  的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k  个数字。滑动窗口每次只向右移动一位。
     *       返回滑动窗口中的最大值。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return nums;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (!dq.isEmpty() && dq.getFirst() < (i - k + 1)) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[i] >= nums[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if (i > k - 1) {
                res[i - k + 1] = nums[dq.getFirst()];
            }
        }
        return res;
    }
}
