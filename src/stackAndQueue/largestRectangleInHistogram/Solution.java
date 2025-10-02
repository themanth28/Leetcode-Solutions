package stackAndQueue.largestRectangleInHistogram;

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int j = 0; j <= n; j++) {
            int h = (j == n) ? 0 : heights[j];

            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int height = heights[stack.pop()];
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                int width = j - leftBoundary - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(j);
        }
        return maxArea;
    }
}