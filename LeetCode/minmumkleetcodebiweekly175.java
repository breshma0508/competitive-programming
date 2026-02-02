/********************************************************************
 *                                                                  *
 *  LEETCODE 3824 – MINIMUM K TO MAKE ARRAY NON-POSITIVE             *
 *                                                                  *
 *  PROBLEM DESCRIPTION:                                            *
 *  Given a positive integer array nums, find the minimum positive *
 *  integer k such that all elements of nums can be made           *
 *  non-positive using at most k^2 operations.                     *
 *  In one operation, you can choose an index i and reduce nums[i] *
 *  by k.                                                           *
 *                                                                  *
 *  EXAMPLES:                                                       *
 *  Example 1: nums = [3,7,5] -> Output: 3                          *
 *    - Reduce 3 by 3 → 0                                           *
 *    - Reduce 7 by 3 three times → -2                              *
 *    - Reduce 5 by 3 two times → -1                                *
 *                                                                  *
 *  Example 2: nums = [1] -> Output: 1                               *
 *    - Reduce 1 by 1 → 0                                           *
 *                                                                  *
 *  APPROACH:                                                       *
 *  1. Use binary search to find the minimum k.                     *
 *  2. For a fixed k, calculate total operations needed as:        *
 *       ops = sum(ceil(nums[i] / k))                               *
 *  3. If ops <= k^2, k is valid.                                   *
 *  4. Adjust search space to find the smallest valid k.           *
 *                                                                  *
 *  COMPLEXITY:                                                     *
 *  Time: O(n log M), where M = max(nums)                           *
 *  Space: O(1)                                                     *
 *                                                                  *
 *  NOTES:                                                          *
 *  - Use integer math for ceil: (nums[i] + k - 1) / k              *
 *  - Upper bound for k can be max(nums)                            *
 ********************************************************************/

class Solution {
    public int minimumK(int[] nums) {
        int l = 1, r = 0;
        for (int n : nums) {
            r = Math.max(r, n);       // upper bound: max value in nums
        }
        r = Math.max(r, nums.length); // ensure upper bound works for small numbers

        int answer = r;

        while (l <= r) {
            int mid = l + (r - l) / 2; // current k to check
            long sum = 0;

            for (int n : nums) {
                // integer ceil division
                sum += (n + mid - 1) / mid;
            }

            if (sum <= (long) mid * mid) {
                // k is valid, try smaller
                answer = mid;
                r = mid - 1;
            } else {
                // k too small, try bigger
                l = mid + 1;
            }
        }

        return answer;
    }
}
