package com.leetcode.LinkedList;

import com.leetcode.Node.ListNode;

public class FindMinRotatedSortedArray {
	public int Solution(int[] num) {
		if (num == null || num.length == 0)
			return 0;
		if (num.length == 1)
			return num[0];

		int start = 0;
		int end = num.length - 1;
		int mid = (start + end) / 2;
		while (start < end) {
			if (mid > 0 && num[mid] < num[mid - 1])
				return num[mid];
			if (num[start] <= num[mid] && num[mid] >= num[end])
				start = mid + 1;
			else
				end = mid - 1;
		}
		return num[start];
	}
}

/* public class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        if (nums[hi] > nums[lo]) return nums[lo];
        while (hi - lo > 1) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[lo]) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return Math.min(nums[lo],nums[hi]);
    }
}
*/

/*public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while(left < right) {
        int mid = left + (right - left) / 2;
        if(nums[mid] < nums[right]) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    return nums[left];
}
 */
