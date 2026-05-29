# 42. Trapping Rain Water

## Problem Statement
Given n non-negative integers representing an elevation map where width of each bar is 1, compute how much water it can trap after raining.

---

## Example 1

Input:
[0,1,0,2,1,0,1,3,2,1,2,1]

Output:
6

Explanation:
The below elevation map traps 6 units of water.

<img width="412" height="161" alt="image" src="https://github.com/user-attachments/assets/9aa9371c-d2d5-4a2f-a9d9-63c0afb2979f" />

---

## Example 2

Input:
[4,2,0,3,2,5]

Output:
9

---

## Intuition

At each index, water trapped depends on:
- tallest bar on left
- tallest bar on right

Water level is limited by the smaller boundary.

---

## Formula

water[i] = min(leftMax[i], rightMax[i]) - height[i]

---

## Approach

1. Build leftMax array
2. Build rightMax array
3. For each index compute water

---

## Code (Java)

class Solution {
    public int trap(int[] height) {

        int n = height.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int water = 0;

        for(int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }
}

---

## Complexity

Time: O(n)  
Space: O(n)

---

## Key Idea
Water is always bounded by the shorter wall.
